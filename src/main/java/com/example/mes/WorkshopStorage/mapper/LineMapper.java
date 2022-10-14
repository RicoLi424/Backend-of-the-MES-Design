package com.example.mes.WorkshopStorage.mapper;

import com.example.mes.WorkshopStorage.entity.Line;
import com.example.mes.WorkshopStorage.vo.LineVo;
import com.example.mes.WorkshopStorage.vo.newLineVo;
import com.example.mes.process.Vo.ProductVo.QueryProductVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface LineMapper {
    LineVo getByName(@Param("workshopId") String workshopId, @Param("lineName") String lineName);
    LineVo getById(@Param("workshopId") String workshopId, @Param("lineId") String lineId);
    LineVo getApplyById(@Param("workshopId") String workshopId, @Param("lineId") String lineId, @Param("company_id") String company_id);
    List<LineVo> getByWorkshop(String workshopId);
    List<LineVo> createInfo(String workshopId);
    List<LineVo> checkByWorkshop(String workshopId);
    LineVo getUpdate(@Param("lineId") String lineId);
    LineVo checkById(@Param("workshopId") String workshop_id, @Param("lineId") String line_id,@Param("company_id") String company_id);
    LineVo checkByPre_id(@Param("workshopId") String workshop_id, @Param("lineId") String line_id);
    void insert(Line line);
    void setNormal(@Param("workshopId") String workshopId, @Param("lineId") String lineId, @Param("modified_time") Timestamp modified_time, @Param("user") String user, @Param("company_id") String company_id);
    void setNormalDelete(@Param("workshopId") String workshopId, @Param("lineId") String lineId, @Param("modified_time") Timestamp modified_time, @Param("user") String user, @Param("company_id") String company_id);
    void setDelete(@Param("workshopId") String workshopId, @Param("lineId") String lineId, @Param("modified_time") Timestamp modified_time, @Param("user") String user, @Param("company_id") String company_id);
    void setNormalByWorkshop(@Param("workshopId") String workshopId, @Param("modified_time") Timestamp modified_time, @Param("user") String user, @Param("company_id") String company_id);
    void setDeleteByWorkshop(@Param("workshopId") String workshopId, @Param("modified_time") Timestamp modified_time, @Param("user") String user, @Param("company_id") String company_id);
    void updateByWorkshop(@Param("workshopId") String workshopId, @Param("pre_id") String pre_id, @Param("company_id") String company_id);
    //TODO :add modified user
    void delete(@Param("workshopId") String workshopId, @Param("lineId") String lineId, @Param("modified_time") Timestamp modified_time);
    Integer getLineNumById(@Param("workshopId") String workshopId,@Param("company_id") String company_id);
    Integer getCount(@Param("company_id") String company_id);
    Integer getApplyCount(@Param("company_id") String company_id);
    List<LineVo> selectAll(@Param("start") long start, @Param("num") long num, @Param("company_id") String company_id);
    List<LineVo> selectApplyAll(@Param("start") long start, @Param("num") long num, @Param("company_id") String company_id);
    List<LineVo> selectAllLine(@Param("workshopId")String workshopId);

    void deleteAllLine(@Param("workshopId") String workshopId, @Param("lineId") String lineId, @Param("modified_time") Timestamp modified_time);

    void setNormalByWorkshop2(@Param("workshopId") String workshopId, @Param("modified_time") Timestamp modified_time, @Param("user") String user, @Param("company_id") String company_id);

    List<QueryProductVo> searchProductId(@Param("company_id") String company_id);

    List<newLineVo> getLinesByWorkshop(@Param("workshopId") String workshopId);

    List<newLineVo> selectPageLines(@Param("workshopId") String workshopId,@Param("company_id") String company_id,@Param("start") long start, @Param("num") long num);

    Integer getCountByWorkshopId(@Param("workshopId") String workshopId,@Param("company_id") String company_id);
}
