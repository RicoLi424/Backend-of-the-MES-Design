package com.example.mes.plan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mes.plan.common.Result;
import com.example.mes.plan.vo.PlanVo;
import com.example.mes.plan.vo.ProcessVo;

import java.util.List;

public interface IProcessService extends IService<ProcessVo> {

	Result<?> materialArrive(String id);
	
	Result<?> increaseProduct(String id,Integer count);
	
	Result<List<ProcessVo>> getProcessesByPlan(PlanVo planVo);
}
