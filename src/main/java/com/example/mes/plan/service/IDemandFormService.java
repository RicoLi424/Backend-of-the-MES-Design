package com.example.mes.plan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mes.plan.common.Result;
import com.example.mes.plan.entity.Line;
import com.example.mes.plan.entity.Product;
import com.example.mes.plan.vo.CriteriaVo;
import com.example.mes.plan.vo.DemandFormVo;
import com.example.mes.plan.vo.PageVo;

import java.util.List;
import java.util.Set;

public interface IDemandFormService extends IService<DemandFormVo> {

	Result<PageVo<DemandFormVo>> getDemandFormPageByCriteria(CriteriaVo<DemandFormVo> criteria);

	Result<?> applyDeletion(DemandFormVo demandForm);

	Result<?> saveDemandForm(DemandFormVo demandForm);

	Result<DemandFormVo> getDemandFormById(String id);

	Result<?> permitDeletion(DemandFormVo demandForm);

	Result<?> permitChange(DemandFormVo demandForm);

	Result<?> rejectDeletion(DemandFormVo demandForm);

	Result<?> rejectChange(DemandFormVo demandForm);
	
	Result<List<DemandFormVo>> getHistoryVersions(DemandFormVo demandForm);

	Result<?> applyChange(DemandFormVo demandFormVo);

	Result<Set<Line>> getLinesByProduct(Product product);
	
	
}
