package com.example.mes.process.Mapper;

import org.apache.ibatis.annotations.Param;

public interface NameIDMapper {

    String getProcedureIDByName(@Param("name") String name);
    String getMaterialIDByNameSizeColor(@Param("name") String name,@Param("size") String size);
    String getMaterialIDByNameSize(@Param("name")String name, @Param("size")String size);
}
