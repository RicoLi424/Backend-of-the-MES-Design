package com.example.mes.plan.controller;

import com.example.mes.plan.common.Result;
import com.example.mes.plan.service.IProcessService;
import com.example.mes.plan.vo.PlanVo;
import com.example.mes.plan.vo.ProcessVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/process")
public class ProcessHandler {

	@Autowired
	private IProcessService processService;
	
	@RequestMapping("/materialArrive")
	@ResponseBody
	public Result<?> materialArrive(@RequestParam("id") String id){
		try {
			return processService.materialArrive(id);
		} catch (Exception e) {
			return Result.error("更新错误");
		}
	}
	
	@RequestMapping("/increaseProduct")
	@ResponseBody
	public Result<?> increaseProduct(@RequestParam("id") String id,@RequestParam("count") Integer count){
		try {
			return processService.increaseProduct(id, count);
		} catch (Exception e) {
			return Result.error("更新错误");
		}
	}
	
	@RequestMapping("/getProcessesByPlan")
	@ResponseBody
	public Result<List<ProcessVo>> getProcessesByPlan(PlanVo planVo){
		try {
			return processService.getProcessesByPlan(planVo);
		} catch (Exception e) {
			return Result.error("获取错误");
		}
	}
}
