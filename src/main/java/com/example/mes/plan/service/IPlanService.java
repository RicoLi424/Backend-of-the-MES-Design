package com.example.mes.plan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mes.plan.common.Result;
import com.example.mes.plan.vo.CriteriaVo;
import com.example.mes.plan.vo.DemandFormVo;
import com.example.mes.plan.vo.PageVo;
import com.example.mes.plan.vo.PlanVo;

import java.util.List;
import java.util.Set;

public interface IPlanService extends IService<PlanVo> {
	Result<?> deletePlan(String id);

	Result<List<PlanVo>> queryLoad(String productionLineId);

	Result<?> savePlan(PlanVo plan);

	Result<?> distributeDemand(String id,Integer count, String dateStr);

	Result<PageVo<PlanVo>> getPlanPageByCriteria(CriteriaVo<PlanVo> criteria);

	Result<?> applyMaterial(String id,String createdBy, String dateStr);
	
	Result<Set<PlanVo>> getPlansByDemandForm(DemandFormVo demandFormVo);

    Result<PageVo<PlanVo>> getPlanPageByCriteriaAndCompany(CriteriaVo<PlanVo> criteria, String company_id);
}
