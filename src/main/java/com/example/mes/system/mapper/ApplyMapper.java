package com.example.mes.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mes.system.entity.Apply;
import com.example.mes.system.entity.Vo.ApplyAddressVo;
import com.example.mes.system.entity.Vo.ApplySelectVo;
import com.example.mes.system.entity.Vo.ApplyStatusVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface ApplyMapper extends BaseMapper<Apply> {

    List<Apply> queryApplyList(@Param("applySelectVo") ApplySelectVo applySelectVo,
                               @Param("numStart") int numStart,
                               @Param("numEnd") int numEnd,
                               @Param("company_id") int company_id);

    int getLastCount(@Param("company_id") int company_id);

    List<ApplyStatusVo> getStatusList(@Param("company_id") int company_id);

    int getStatus(String status,String company_id);

    void applyAddress(@Param("n") ApplyAddressVo applyAddressVo,
                      @Param("currentTime") Timestamp currentTime,
                      @Param("status") String status,
                      @Param("handled_id") String handled_id);

    int getUserId(Integer log_id);

    String getDepartment(Integer apply_id);

    String getRole(Integer apply_id);

    void setUserDepartment(int transfer_id, String department,
                           @Param("currentTime") Timestamp currentTime,
                           String handled_by);
    void setUserRole(int transfer_id, String role,
                           @Param("currentTime") Timestamp currentTime,
                           String handled_by);

    void applyRefuse(Integer log_id, String status, Timestamp currentTime, String handled_id);

    int getTransferId(Integer log_id);

}
