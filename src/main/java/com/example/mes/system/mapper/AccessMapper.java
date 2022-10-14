package com.example.mes.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mes.system.entity.Access;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccessMapper extends BaseMapper<Access> {
    String getPermission(Integer id);

    List<String> getAccessNames(String permission_name);

    List<String> getAccessKeys(List<String> access_name);
}
