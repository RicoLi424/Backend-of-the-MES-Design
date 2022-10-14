package com.example.mes.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mes.system.entity.Permission;
import com.example.mes.system.entity.Vo.PermissionSelectVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {
    List<String> findByName(@Param("permissionSelectVo") PermissionSelectVo permissionSelectVo, @Param("numStart") int numStart, @Param("numEnd") int numEnd);

    List<String> findAccessName(String permission_name,Integer company_id);

    int getLastCount(Integer company_id);

    List<String> FindAllAccessName();

    void permissionDelete(String permission_name, Timestamp modified_time, String modified_by);

    String permissionFind(String permission_name,Integer company_id);

    void permissionUpdate(@Param("permission_name") String permissionName,
                          @Param("access_name") String access_name,
                          @Param("modified_time") Timestamp modified_time,
                          @Param("modified_by") String modified_by,
                          @Param("status") String status,
                          @Param("is_deleted") String is_deleted,
                          @Param("company_id") Integer company_id
    );

    void permissionAllDelete(@Param("name") String name,@Param("company_id") Integer company_id);

    List<Permission> getDefaultPermission();
}
