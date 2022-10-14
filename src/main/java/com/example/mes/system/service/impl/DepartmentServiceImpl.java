package com.example.mes.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mes.system.entity.Department;
import com.example.mes.system.entity.Vo.DepartmentCountVo;
import com.example.mes.system.entity.Vo.DepartmentSelectVo;
import com.example.mes.system.entity.Vo.DepartmentUpdateVo;
import com.example.mes.system.entity.Vo.newDepartmentUpdateVo;
import com.example.mes.system.mapper.DepartmentMapper;
import com.example.mes.system.mapper.RoleMapper;
import com.example.mes.system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Department> queryDepartmentList(DepartmentSelectVo departmentSelectVo) {
        int numStart = MyImplUtils.getNumStart(departmentSelectVo.getPageNum(), departmentSelectVo.getPageSize());
        int numEnd = MyImplUtils.getNumEnd(departmentSelectVo.getPageSize());
        return departmentMapper.queryDepartmentList(departmentSelectVo, numStart, numEnd);
    }

    @Override
    public int getLastCount(Integer company_id) {
        return departmentMapper.getLastCount(company_id);
    }

    @Override
    public void departmentDelete(Department department,int handler,int company_id) {
        department.setModified_by(Integer.toString(handler));
        department.setModified_time(MyImplUtils.getCurrentTime());
        department.setCompany_id(company_id);
        departmentMapper.departmentDelete(department);
    }

    @Override
    public Department departmentFind(DepartmentUpdateVo departmentUpdateVo) {
        return departmentMapper.departmentFind(departmentUpdateVo.getDepartment_name());
    }

    @Override
    public void departmentUpdate(DepartmentUpdateVo departmentUpdateVo) {
        departmentUpdateVo.setModified_by(Integer.toString(departmentUpdateVo.getUser().getId()));
        departmentUpdateVo.setModified_time(MyImplUtils.getCurrentTime());
        departmentMapper.departmentUpdate(departmentUpdateVo);
    }

    //修改部门信息（更新所含角色）
    @Override
    public void newDepartmentUpdate(newDepartmentUpdateVo newdepartmentUpdateVo) {
        newdepartmentUpdateVo.setModified_by(Integer.toString(newdepartmentUpdateVo.getUser().getId()));
        newdepartmentUpdateVo.setModified_time(MyImplUtils.getCurrentTime());
//        departmentMapper.departmentUpdate(newdepartmentUpdateVo);
        //改部门信息
        departmentMapper.newdepartmentUpdate(newdepartmentUpdateVo);

        //改部门里的角色
        String AllRoleName = newdepartmentUpdateVo.getRole_name();
        String []roleName = AllRoleName.split(",");

        for(String r:roleName){
            //将部门所属角色加上部门名
            roleMapper.updateDepartmentName(r,Integer.toString(newdepartmentUpdateVo.getCompany_id()),newdepartmentUpdateVo.getDepartment_name());
        }
    }

    //增加部门
    @Override
    public void departmentAdd(DepartmentUpdateVo departmentUpdateVo) {

        departmentUpdateVo.setCreated_time(MyImplUtils.getCurrentTime());
        departmentUpdateVo.setModified_time(departmentUpdateVo.getCreated_time());
        departmentUpdateVo.setCreated_by(Integer.toString(departmentUpdateVo.getUser().getId()));
        departmentUpdateVo.setModified_by(departmentUpdateVo.getCreated_by());
        departmentUpdateVo.setStatus("0");
        departmentUpdateVo.setIs_deleted("0");
        departmentUpdateVo.setCompany_id(departmentUpdateVo.getCompany_id());
        departmentMapper.departmentInsert(departmentUpdateVo);

    }

    //增加新部门（包含角色）
    @Override
    public void newDepartmentAdd(newDepartmentUpdateVo newdepartmentUpdateVo) {

        newdepartmentUpdateVo.setCreated_time(MyImplUtils.getCurrentTime());
        newdepartmentUpdateVo.setModified_time(newdepartmentUpdateVo.getCreated_time());
        newdepartmentUpdateVo.setCreated_by(Integer.toString(newdepartmentUpdateVo.getUser().getId()));
        newdepartmentUpdateVo.setModified_by(newdepartmentUpdateVo.getCreated_by());
        newdepartmentUpdateVo.setStatus("0");
        newdepartmentUpdateVo.setIs_deleted("0");
        newdepartmentUpdateVo.setCompany_id(newdepartmentUpdateVo.getCompany_id());

        //部门插入数据库
        departmentMapper.newdepartmentInsert(newdepartmentUpdateVo);

        //得到每个角色名
        String AllRoleName = newdepartmentUpdateVo.getRole_name();
        String []roleName = AllRoleName.split(",");

        for(String role_name:roleName){

            System.out.println(role_name);
            System.out.println(newdepartmentUpdateVo.getDepartment_name());
            System.out.println(newdepartmentUpdateVo.getCompany_id());

            //将部门所属角色加上部门名
            roleMapper.updateDepartmentName(role_name,Integer.toString(newdepartmentUpdateVo.getCompany_id()),newdepartmentUpdateVo.getDepartment_name());
        }

    }


    @Override
    public List<DepartmentCountVo> getDepartmentCount(Integer company_id) {
        return departmentMapper.getDepartmentCount(company_id);
    }


    @Override
    public Department newdepartmentFind(newDepartmentUpdateVo newdepartmentUpdateVo) {
        return departmentMapper.newdepartmentFind(newdepartmentUpdateVo.getDepartment_name(),Integer.toString(newdepartmentUpdateVo.getCompany_id()));
    }

    @Override
    public  void setDefaultDepartment(Integer user_id, Integer company_id,Integer new_user_id){
        List<Department> departmentList = departmentMapper.getDefaultDepartment();
        newDepartmentUpdateVo newDepartmentUpdateVo = new newDepartmentUpdateVo();
        for(Department department : departmentList){
            newDepartmentUpdateVo.setDepartment_name(department.getDepartment_name());
            newDepartmentUpdateVo.setCompany_id(company_id);
            newDepartmentUpdateVo.setManager_name(department.getManager_name());
            //该公司超管的id
            newDepartmentUpdateVo.setManager_id(new_user_id);
            newDepartmentUpdateVo.setDepartment_describe(department.getDepartment_describe());
            newDepartmentUpdateVo.setStatus("0");
            newDepartmentUpdateVo.setIs_deleted("0");
            newDepartmentUpdateVo.setCreated_time(MyImplUtils.getCurrentTime());
            newDepartmentUpdateVo.setModified_time(newDepartmentUpdateVo.getCreated_time());
            newDepartmentUpdateVo.setCreated_by(Integer.toString(user_id));
            newDepartmentUpdateVo.setModified_by(newDepartmentUpdateVo.getCreated_by());
            departmentMapper.newdepartmentInsert(newDepartmentUpdateVo);
        }
    }

}
