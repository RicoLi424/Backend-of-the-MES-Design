package com.example.mes.WorkshopStorage.mapper;

import com.example.mes.WorkshopStorage.entity.Workshop;
import com.example.mes.WorkshopStorage.vo.Result;
import com.example.mes.WorkshopStorage.vo.WorkshopVo;
import com.example.mes.WorkshopStorage.vo.newWorkshopVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface WorkshopMapper {

    List<WorkshopVo> selectAll(@Param("start") long start, @Param("num") long num);
    List<WorkshopVo> selectApplyAll(@Param("start") long start, @Param("num") long num,@Param("company_id") String company_id);

    List<WorkshopVo> all_workshop(String company_id);
    WorkshopVo getById(@Param("workshopId") String workshopId,@Param("company_id") String company_id);
    WorkshopVo getApplyById(@Param("workshopId") String workshopId,@Param("company_id") String company_id);
    WorkshopVo getByName(@Param("workshopName") String workshopName,@Param("company_id") String company_id);
    WorkshopVo createInfo(@Param("workshopId") String workshopId);
    Integer getCount(@Param("company_id") String company_id);
    Integer getApplyCount(@Param("company_id") String company_id);
    void insert(Workshop params);
    void setNormal(@Param("workshopId") String workshopId, @Param("modified_time") Timestamp modified_time, @Param("user") String user,@Param("company_id") String company_id);
    void setNormalDelete(@Param("workshopId") String workshopId, @Param("modified_time") Timestamp modified_time, @Param("user") String user,@Param("company_id") String company_id);
    void setDelete(@Param("workshopId") String workshopId, @Param("modified_time") Timestamp modified_time, @Param("user") String user,@Param("company_id") String company_id);
    WorkshopVo checkById(@Param("workshopId") String workshopId,@Param("company_id") String company_id);
    WorkshopVo checkByPre_id(@Param("workshopId") String workshopId);
    //TODO :add modified user
    void deleteWorkshop(@Param("workshopId") String workshopId, @Param("modified_time") Timestamp modified_time);

    newWorkshopVo getWorkshopById(@Param("workshopId") String workshopId);
    newWorkshopVo getWorkshopInfo(@Param("workshopId") String workshopId);
}
