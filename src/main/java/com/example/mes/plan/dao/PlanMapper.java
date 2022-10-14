package com.example.mes.plan.dao;

import com.example.mes.plan.common.MesBaseMapper;
import com.example.mes.plan.entity.Plan;
import com.example.mes.plan.vo.CriteriaVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PlanMapper extends MesBaseMapper<Plan>{

	List<Plan> getPlansByProductionLineId(@Param("productionLineId")String id);

//	void updatePlan(Plan plan);
	
	
	void updateDistributeTime(String id);

	List<Plan> getPlanByCriteria(CriteriaVo<Plan> criteria);

	Integer getCountByCriteria(CriteriaVo<Plan> criteria);

	Set<Plan> getPlansByDemandFormId(String id);


}
