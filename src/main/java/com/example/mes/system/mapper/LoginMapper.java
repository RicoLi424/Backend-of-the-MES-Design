package com.example.mes.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mes.system.entity.Permission;
import com.example.mes.system.entity.User;
import com.example.mes.system.entity.Vo.LoginVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface LoginMapper extends BaseMapper<Permission> {
    User getUser(@Param("loginVo") LoginVo loginVo);

    String getPermissionName(String roleName, Integer company_id);

    List<String> getAccessName(String permissionName, Integer company_id);

}
