package com.example.mes.system.controller;

import com.example.mes.system.entity.Apply;
import com.example.mes.system.entity.Vo.ApplyAddressVo;
import com.example.mes.system.entity.Vo.ApplySelectVo;
import com.example.mes.system.entity.Vo.ApplyStatusVo;
import com.example.mes.system.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/data/applyManagement/")
public class ApplyController {
    @Autowired
    ApplyService applyService;

    @PostMapping("/applyList")
    public Object queryApplyList(
            @RequestBody ApplySelectVo applySelectVo
    ) {
        HashMap<String, Object> res = new HashMap<>();
        List<Apply> applyList = applyService.queryApplyList(applySelectVo);
        int getApplyListCount = applyService.getLastCount(applySelectVo.getUser().getCompany_id());
        List<ApplyStatusVo> statusList = applyService.getStatusList(applySelectVo.getUser().getCompany_id());

        res.put("total", getApplyListCount);
        res.put("applyList", applyList);
        res.put("statusList", statusList);
        MyUtils.success(res);
        return res;
    }

    @PostMapping("/toBeAddress")
    public int toBeAddress(String company_id) {
        return applyService.getStatus("待审核",company_id);
    }

    @PostMapping("/applySingleAddress")
    public Object applySingleAddress(
            @RequestBody ApplyAddressVo applyAddressVo
    ) {
        HashMap<String, Object> res = new HashMap<>();
        String isAccept = applyAddressVo.getIsAccept();
        if (isAccept.equals("1")) {
            String getDepartment = applyService.getDepartment(applyAddressVo.getApply_id());
            String getRole = applyService.getRole(applyAddressVo.getApply_id());

            int transfer_id = applyService.applyAddress(applyAddressVo);
            applyService.setUserDepartment(transfer_id, getDepartment,applyAddressVo.getUser().getId());
            applyService.setUserRole(transfer_id, getRole,applyAddressVo.getUser().getId());
            MyUtils.successMsg(res, "成功,同意部门转换");
        } else if (isAccept.equals("0")) {
            applyService.applyRefusal(applyAddressVo);
            MyUtils.successMsg(res, "成功,拒绝部门转换");
        } else {
            MyUtils.fail(res, "错误参数传递");
        }
        return res;
    }


    @PostMapping("/applyAddress")
    public Object applyAddress(
            @RequestBody List<ApplyAddressVo> applyAddressVos
    ) {
        HashMap<String, Object> res = new HashMap<>();
        for (ApplyAddressVo applyAddressVo : applyAddressVos) {
            String isAccept = applyAddressVo.getIsAccept();
            if (isAccept.equals("1")) {
                String getDepartment = applyService.getDepartment(applyAddressVo.getApply_id());
                String getRole = applyService.getRole(applyAddressVo.getApply_id());

                int transfer_id = applyService.applyAddress(applyAddressVo);

                applyService.setUserDepartment(transfer_id, getDepartment,applyAddressVo.getUser().getId());
                applyService.setUserRole(transfer_id, getRole,applyAddressVo.getUser().getId());

                MyUtils.successMsg(res, "成功,同意" + transfer_id + "部门转换");
            } else if (isAccept.equals("0")) {
                int transfer_id = applyService.getTransferId(applyAddressVo);
                applyService.applyRefusal(applyAddressVo);
                MyUtils.successMsg(res, "成功,拒绝" + transfer_id + "部门转换");
            } else {
                MyUtils.fail(res, "错误参数传递");
            }
        }
        return res;
    }


}
