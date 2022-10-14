package com.example.mes.WorkshopStorage.mapper;

import com.example.mes.WorkshopStorage.vo.newStationVo;
import com.example.mes.WorkshopStorage.vo.StationVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface StationMapper {
    StationVo getUpdate(@Param("stationId") String stationId);
    List<StationVo> selectApplyAll(@Param("start") long start, @Param("num") long num,@Param("company_id") String company_id);
    List<StationVo> createInfo(@Param("workshop_id") String workshop_id, @Param("line_id") String line_id);
    List<newStationVo> getByLine(@Param("workshop_id") String workshop_id, @Param("line_id") String line_id, @Param("company_id") String company_id);
    List<StationVo> checkByLine(@Param("workshop_id") String workshop_id, @Param("line_id") String line_id);
    StationVo getApplyById(@Param("workshop_id") String workshop_id, @Param("line_id") String line_id, @Param("station_id") String station_id,@Param("company_id") String company_id);
    StationVo getById(@Param("workshop_id") String workshop_id, @Param("line_id") String line_id, @Param("station_id") String station_id);
    StationVo checkById(@Param("workshop_id") String workshop_id, @Param("line_id") String line_id, @Param("station_id") String station_id);
    StationVo checkByPre_id(@Param("workshopId") String workshop_id, @Param("lineId") String line_id, @Param("stationId") String station_id);
    void insert(StationVo stationVo);
    void updateByWorkshop(@Param("workshopId") String workshopId, @Param("pre_id") String pre_id,@Param("company_id") String company_id);
    void updateByLine(@Param("workshopId") String workshopId, @Param("lineId") String lineId, @Param("pre_id") String pre_id,@Param("company_id") String company_id);
    void setNormalDelete(@Param("workshopId") String workshopId, @Param("lineId") String lineId, @Param("stationId") String stationId, @Param("modified_time") Timestamp modified_time, @Param("user") String user,@Param("company_id") String company_id);
    void setNormal(@Param("workshopId") String workshopId, @Param("lineId") String lineId, @Param("stationId") String stationId, @Param("modified_time") Timestamp modified_time, @Param("user") String user,@Param("company_id") String company_id);
    void setDelete(@Param("workshopId") String workshopId, @Param("lineId") String lineId, @Param("stationId") String stationId, @Param("modified_time") Timestamp modified_time, @Param("user") String user,@Param("company_id") String company_id);
    void setNormalByWorkshop(@Param("workshopId") String workshopId, @Param("modified_time") Timestamp modified_time, @Param("user") String user,@Param("company_id") String company_id);
    void setDeleteByWorkshop(@Param("workshopId") String workshopId, @Param("modified_time") Timestamp modified_time, @Param("user") String user,@Param("company_id") String company_id);
    Integer getApplyCount(@Param("company_id") String company_id);
    Integer getStationNumByworkshopId(@Param("workshopId") String workshopId,@Param("company_id") String company_id);
    Integer getEquipNumByLineId(@Param("workshopId") String workshopId, @Param("lineId") String lineId, @Param("company_id") String company_id);
    Integer getStationNumByLineId(@Param("workshopId") String workshopId, @Param("lineId") String lineId,@Param("company_id") String company_id);
    void delete(@Param("workshopId") String workshopId, @Param("lineId") String lineId, @Param("stationId") String stationId, @Param("modified_time") Timestamp modified_time);
    List<StationVo> selectAllStation(@Param("workshopId") String workshopId, @Param("lineId") String lineId);

    void setNormalByWorkshop2(@Param("workshopId") String workshopId, @Param("modified_time") Timestamp modified_time, @Param("user") String user, @Param("company_id") String company_id);

    void setNormal2(@Param("workshopId") String workshopId, @Param("lineId") String lineId, @Param("modified_time") Timestamp modified_time, @Param("user") String user,@Param("company_id") String company_id);

    void insertStations(StationVo stationVo);
}
