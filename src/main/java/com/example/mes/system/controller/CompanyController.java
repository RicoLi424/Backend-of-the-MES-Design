package com.example.mes.system.controller;

import com.example.mes.system.entity.Company;
import com.example.mes.system.entity.Vo.UserUpdateVo;
import com.example.mes.system.entity.Vo.CompanyDeleteVo;
import com.example.mes.system.entity.Vo.CompanySelectVo;
import com.example.mes.system.entity.Vo.CompanyUpdateVo;
import com.example.mes.system.service.*;
import com.example.mes.system.service.impl.MyImplUtils;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("data/companyManagement/")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/companyList")
    public Object queryCompanyList(
            @RequestBody CompanySelectVo companySelectVo
    ) {
        HashMap<String, Object> res = new HashMap<>();
        List<Company> companyList = companyService.queryCompanyList(companySelectVo);
        int companyListCount = companyService.getLastCount();
        res.put("companyList", companyList);
        res.put("total", companyListCount);
        MyUtils.success(res);
        return res;
    }


    @PostMapping("/companyDelete")
    public Object companyDelete(
            @RequestBody CompanyDeleteVo companyDeleteVo
            ) {
        HashMap<String, Object> res = new HashMap<>();
        for (Company company : companyDeleteVo.getCompanyList()) {
            companyService.companyDelete(company,companyDeleteVo.getUser().getId());
        }
        MyUtils.success(res);
        return res;
    }

    @PostMapping("/companyUpdate")
    public Object companyUpdate(
            @RequestBody CompanyUpdateVo companyUpdateVo
    ) {
        HashMap<String, Object> res = new HashMap<>();
        Company company = companyService.companyFind(companyUpdateVo);
        if (companyUpdateVo.getRequest().equals("update")) {
            if (company == null) {
                MyUtils.fail(res, "该公司不存在");
            } else {
                //该方法只能对数据进行直接修改，没有判断id和name的逻辑，需要添加
                companyService.companyUpdate(companyUpdateVo);
                MyUtils.success(res);
            }
        } else if (companyUpdateVo.getRequest().equals("insert")) {
            if (company != null) {
                if (company.getMail().equals(companyUpdateVo.getMail())){
                    MyUtils.fail(res, "该邮箱已被使用,无法注册新公司");
                }else {
                    MyUtils.fail(res, "该公司已经存在，请勿重复创建");
                }
            } else {
                // 现在的版本只能生成新的公司，但不会自动指定id，同时不会自动生成超管，现需在controller对id进行自动分配，并且自动生成超管，res里需要填充至少一段message，同时可能带有company_id、user_id字段
                //1.自动生成id
                Company lastCompany = companyService.getLastData();
                int new_company_id = lastCompany.getCompany_id()+1;
                companyUpdateVo.setCompany_id(new_company_id);
                companyUpdateVo.setStatus("正常运行");
                companyService.companyInsert(companyUpdateVo);
                //2.生成超管账号（默认账号为company_id+100000,密码为100000，暂不提供修改密码的方法）
                int new_user_id = new_company_id*100000+10000;
                UserUpdateVo new_user = new UserUpdateVo();
                new_user.id = new_user_id;
                new_user.name = "超级管理员";
                new_user.age = 0;
                new_user.sex = 0;
                new_user.pwd = "100000";
                new_user.department = "默认部门";
                new_user.user_name = String.valueOf(new_user_id);
                new_user.role = "超级管理员";
                new_user.company_id = new_company_id;
                new_user.user = companyUpdateVo.getUser();
                new_user.user.setId(100000);
                userService.userAdd(new_user);

                //3.自动生成默认的权限、角色、部门等
                //生成默认权限
                permissionService.setDefaultPermission(new_user.id,new_company_id);
                //生成默认角色
                roleService.setDefaultRole(new_user.id,new_company_id);
                //生成默认部门
                departmentService.setDefaultDepartment(new_user.id,new_company_id,new_user_id);
                res.put("company_id", new_company_id);
                MyUtils.success(res);
            }
        }else  if(companyUpdateVo.getRequest().equals("register")) {
            if (company != null) {
                if (company.getMail().equals(companyUpdateVo.getMail())) {
                    MyUtils.fail(res, "该邮箱已被使用,无法注册新公司");
                } else {
                    MyUtils.fail(res, "该公司已经存在，请勿重复创建");
                }
            } else {
                Company lastCompany = companyService.getLastData();
                int new_company_id = lastCompany.getCompany_id() + 1;
                companyUpdateVo.setCompany_id(new_company_id);
                companyUpdateVo.setStatus("待审核");
                companyService.companyInsert(companyUpdateVo);
                res.put("company_id", new_company_id);
                MyUtils.success(res);
            }
        }else if (companyUpdateVo.getRequest().equals("commit")){
            companyUpdateVo.setStatus("正常运行");
            companyService.companyUpdate(companyUpdateVo);
            Integer new_company_id = companyUpdateVo.getCompany_id();
            //2.生成超管账号（默认账号为company_id+100000,密码为100000，暂不提供修改密码的方法）
            int new_user_id = new_company_id*100000+10000;
            UserUpdateVo new_user = new UserUpdateVo();
            new_user.id = new_user_id;
            new_user.name = "超级管理员";
            new_user.age = 0;
            new_user.sex = 0;
            new_user.pwd = "100000";
            new_user.department = "默认部门";
            new_user.user_name = String.valueOf(new_user_id);
            new_user.role = "超级管理员";
            new_user.company_id = new_company_id;
            new_user.user = companyUpdateVo.getUser();
            new_user.user.setId(100000);
            userService.userAdd(new_user);
            //3.自动生成默认的权限、角色、部门等
            //生成默认权限
            permissionService.setDefaultPermission(new_user.id,new_company_id);
            //生成默认角色
            roleService.setDefaultRole(new_user.id,new_company_id);
            //生成默认部门
            departmentService.setDefaultDepartment(new_user.id,new_company_id,new_user_id);
            MyUtils.success(res);
        }else  if (companyUpdateVo.getRequest().equals("refuse")){
            companyUpdateVo.setStatus("审核不通过");
            companyUpdateVo.setIs_deleted("1");
            companyService.companyUpdate(companyUpdateVo);
            MyUtils.success(res);
        }

        return res;
    }


}
