package com.example.mes.WorkshopStorage.mapper;

import com.example.mes.WorkshopStorage.vo.ApplyVo;
import com.example.mes.WorkshopStorage.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface GoodsMapper {
    GoodsVo getById (@Param("storage_id") String storage_id, @Param("shelf_id") String shelf_id, @Param("id")String id, String company_id);
    List<GoodsVo> getByShelfId (@Param("storage_id") String storage_id, @Param("shelf_id") String shelf_id, String company_id);
    Integer getGoodsNumById(@Param("storage_id") String storage_id, @Param("shelf_id") String shelf_id, String company_id);
    void insert(GoodsVo params);
    void updateQuantity(String storage_id, String shelf_id, String id, int quantity, Timestamp modified_time, String company_id);
    List<GoodsVo> getApplyByShelf(@Param("storage_id") String storage_id, @Param("shelf_id") String shelf_id, String company_id);
    void removeById(String storage_id, String shelf_id, String id, int quantity, Timestamp modified_time, String user, String company_id);
    void delete(String storage_id, String shelf_id, String id, Timestamp modified_time, String company_id);
    String getMaterial(String id, String company_id);
    String getEquipment(String id, String company_id);
    void addApply(ApplyVo applyVo);
    List<ApplyVo> selectAll(long start,long num, String company_id);
    List<ApplyVo> selectAll_search(long start,long num, String goods_id, String goods_name, Date time1, Date time2, String type, String company_id);
    List<ApplyVo> selectsetAll(long start,long num, String company_id);
    List<ApplyVo> selectConfirmAll(long start,long num, String company_id);
    List<ApplyVo> selectMessageAll(long start,long num, String company_id);
    List<ApplyVo> selectAddAll(long start,long num, String company_id);
    List<GoodsVo> selectGoodsAll(long start,long num, String storage_id, String shelf_id, String company_id);
    List<GoodsVo> selectLocationAll(long start,long num, String type, String id, String company_id);
    List<GoodsVo> search_out(String uuid, String company_id);
    Integer search_quantity(String uuid, String company_id);
    List<ApplyVo> getOrderByTime(String uuid, String company_id);
    Integer searchQuantity(String goods_id, String types, String company_id);
    Integer getApplyCount(String company_id);
    Integer getApplyCount_search(String goods_id, String goods_name, Date time1, Date time2, String type, String company_id);
    Integer getsetApplyCount(String company_id);
    Integer getConfirmCount(String company_id);
    Integer getMessageCount(String company_id);
    Integer getGoodsCount(String storage_id, String shelf_id, String company_id);
    Integer getAddCount(String company_id);
    Integer getLocationCount(String type, String id, String company_id);
    void setApply(String uuid, String user, Timestamp timestamp, String company_id);
    ApplyVo getByUuid(String uuid, String company_id);
    void managerConfirm_in(String uuid,String uuid1, String random, String company_id);
    void managerConfirm_out(String uuid, String company_id);
    void managerConfirm_out1(String uuid, int quantity, String company_id);
    void managerConfirm(String uuid, String message, String user, Timestamp timestamp, String company_id);
    void managerConfirm1(String uuid, String message, String company_id);
    void checkDelete(String company_id);
    void removeApply(String uuid, String user, Timestamp timestamp, String company_id);
}