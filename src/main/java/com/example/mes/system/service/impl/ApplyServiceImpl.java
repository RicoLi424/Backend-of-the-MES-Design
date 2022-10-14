package com.example.mes.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mes.system.entity.Apply;
import com.example.mes.system.entity.Vo.ApplyAddressVo;
import com.example.mes.system.entity.Vo.ApplySelectVo;
import com.example.mes.system.entity.Vo.ApplyStatusVo;
import com.example.mes.system.mapper.ApplyMapper;
import com.example.mes.system.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ApplyServiceImpl extends ServiceImpl<ApplyMapper, Apply> implements ApplyService {
    @Autowired
    ApplyMapper applyMapper;

    @Override
    public List<Apply> queryApplyList(ApplySelectVo applySelectVo) {
        int numStart = MyImplUtils.getNumStart(applySelectVo.getPageNum(), applySelectVo.getPageSize());
        int numEnd = MyImplUtils.getNumEnd(applySelectVo.getPageSize());
        System.out.println(applySelectVo.getUser().getCompany_id());
        return applyMapper.queryApplyList(applySelectVo, numStart, numEnd,applySelectVo.getUser().getCompany_id());
    }

    @Override
    public int getLastCount(Integer company_id) {
        return applyMapper.getLastCount(company_id);
    }

    @Override
    public List<ApplyStatusVo> getStatusList(Integer company_id) {
        return applyMapper.getStatusList(company_id);
    }

    @Override
    public int getStatus(String s,String company_id) {
        return applyMapper.getStatus(s,company_id);
    }

    @Override
    public int applyAddress(ApplyAddressVo applyAddressVo) {
        Timestamp currentTime = MyImplUtils.getCurrentTime();
        String status = "同意";
//        String handled_id = Integer.toString(applyAddressVo.getUser().getId());
        String handled_id = applyAddressVo.getUser().getName();
        applyMapper.applyAddress(applyAddressVo, currentTime, status, handled_id);
        return applyMapper.getUserId(applyAddressVo.getApply_id());
    }

    @Override
    public String getDepartment(Integer apply_id) {
        return applyMapper.getDepartment(apply_id);
    }

    @Override
    public String getRole(Integer apply_id) {
        return applyMapper.getRole(apply_id);
    }

    @Override
    public void setUserDepartment(int transfer_id, String getDepartment, int handler) {
        String handled_by = Integer.toString(handler);
        Timestamp currentTime = MyImplUtils.getCurrentTime();
        applyMapper.setUserDepartment(transfer_id, getDepartment, currentTime,handled_by);
    }

    @Override
    public void setUserRole(int transfer_id, String getRole, int handler) {
        String handled_by = Integer.toString(handler);
        Timestamp currentTime = MyImplUtils.getCurrentTime();
        applyMapper.setUserRole(transfer_id, getRole, currentTime,handled_by);
    }

    @Override
    public void applyRefusal(ApplyAddressVo applyAddressVo) {
        Timestamp currentTime = MyImplUtils.getCurrentTime();
        String status = "拒绝";
        String handled_id = Integer.toString(applyAddressVo.getUser().getId());
        applyMapper.applyRefuse(applyAddressVo.getApply_id(), status, currentTime, handled_id);
    }

    @Override
    public int getTransferId(ApplyAddressVo applyAddressVo) {
        return applyMapper.getTransferId(applyAddressVo.getApply_id());
    }


}
