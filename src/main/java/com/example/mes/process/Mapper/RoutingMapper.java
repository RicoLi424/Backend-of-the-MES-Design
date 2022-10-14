package com.example.mes.process.Mapper;

import com.example.mes.process.Vo.RoutingVo.*;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface RoutingMapper {

    //根据工艺路线id，获得工艺路线信息
    QueryRoutingVo getRoutingByID(@Param("routing_id") String routing_id);
    //根据工艺路线id，获得该工艺路线的详细信息
    ArrayList<QueryRoutingProcedureVo> getRoutingInfosByID(@Param("routing_id") String routing_id);
    //根据id获得成本
    double getCostByID(@Param("routing_id") String routing_id);
    //逻辑删除工艺路线
    boolean deleteRoutingByID(@Param("deleteRoutingVo")DeleteRoutingVo deleteRoutingVo);
    //插入工艺路线概要信息
    boolean addRouting(@Param("insertRoutingVo") InsertRoutingVo insertRoutingVo);
    //插入工艺路线具体信息
    boolean addRoutingInfos(@Param("list")ArrayList<InsertRoutingProcedureVo> list);
    //更新工艺路线信息，可以更新status跟comments
    boolean updateRoutingByID(@Param("updateRoutingVo") UpdateRoutingVo updateRoutingVo);
    //删除联系表中的工艺路线与工序的记录，用于更新
    boolean deleteRoutingProcedureByID(@Param("routing_id") String routing_id);





}
