package com.example.mes.WorkshopStorage.mapper;

import com.example.mes.WorkshopStorage.vo.ShelfVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ShelfMapper {
    Integer getShelfNumByStorageId(@Param("storage_id") String storage_id,String company_id);
    Integer getCount(String company_id);
    ShelfVo getById(@Param("storage_id")String storage_id, @Param("id") String id,String company_id);
    Integer getCountById(@Param("storage_id") String storage_id,String company_id);
    void insert(ShelfVo shelfVo);
    void delete(String storage_id, String id, String user, Timestamp modified_time,String company_id);
    List<ShelfVo> shelfById(@Param("storage_id") String storage_id,String company_id);
    List<ShelfVo> selectAll (@Param("start") long start, @Param("num") long num,String company_id);
    List<ShelfVo> selectAllById (@Param("storage_id") String storage_id, @Param("start") long start, @Param("num") long num,String company_id);
}
