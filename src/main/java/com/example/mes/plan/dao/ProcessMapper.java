package com.example.mes.plan.dao;

import com.example.mes.plan.common.MesBaseMapper;
import com.example.mes.plan.entity.Process;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProcessMapper extends MesBaseMapper<Process> {
	
//	void updateProcess(Process process);

	void updateMaterialArriveTime(String id);
	
	List<Process> selectByPlanId(@Param("planId")String id);
	
	void updateProducedQuantity(Process process);
	
	void updateFinishTime(Process process);
}
