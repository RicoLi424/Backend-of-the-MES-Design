package com.example.mes.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mes.system.entity.Apply;
import com.example.mes.system.entity.Vo.ApplyAddressVo;
import com.example.mes.system.entity.Vo.ApplySelectVo;
import com.example.mes.system.entity.Vo.ApplyStatusVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplyService extends IService<Apply> {
    List<Apply> queryApplyList(ApplySelectVo applySelectVo);

    int getLastCount(Integer company_id);


    List<ApplyStatusVo> getStatusList(Integer company_id);

    int getStatus(String s,String company_id);

    int applyAddress(ApplyAddressVo applyAddressVo);

    String getDepartment(Integer apply_id);

    String getRole(Integer apply_id);

    void setUserDepartment(int transfer_id, String getDepartment, int handler);

    void setUserRole(int transfer_id, String getRole, int handler);

    void applyRefusal(ApplyAddressVo applyAddressVo);

    int getTransferId(ApplyAddressVo applyAddressVo);
}
