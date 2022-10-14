package com.example.mes.plan.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface MesBaseMapper<T>extends BaseMapper<T> {
	void updateStatus(@Param("id")String id,@Param("status")String status);
	
	void updateDeleted(@Param("id")String id,@Param("deleted")String deleted);
	
	
}
