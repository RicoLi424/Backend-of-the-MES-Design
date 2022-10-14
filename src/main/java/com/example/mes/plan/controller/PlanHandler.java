package com.example.mes.plan.controller;

import com.example.mes.plan.common.Result;
import com.example.mes.plan.service.IPlanService;
import com.example.mes.plan.vo.CriteriaVo;
import com.example.mes.plan.vo.DemandFormVo;
import com.example.mes.plan.vo.PageVo;
import com.example.mes.plan.vo.PlanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/plan")
public class PlanHandler {
	
	@Autowired
	private IPlanService planService;
	
	@RequestMapping("/deletePlan")
	@ResponseBody
	public Result<?> deletePlan(@RequestParam("id") String id){
		try {
			return planService.deletePlan(id);
		} catch (Exception e) {
			return Result.error("删除失败");
		} 
	}
	
	@RequestMapping("/queryLoad")
	@ResponseBody
	public Result<List<PlanVo>> queryLoad(@RequestParam("id") String productionLineId){
		try {
			return planService.queryLoad(productionLineId);
		} catch (Exception e) {
			return Result.error("查询失败");
		}
	}
	
	//
	@RequestMapping("/savePlan")
	@ResponseBody
	public Result<?> savePlan(PlanVo plan){
		try {
			return planService.savePlan(plan);
		} catch (Exception e) {
			return Result.error("保存失败");
		}
	}
	
	@RequestMapping("/distributeDemand")
	@ResponseBody
	public Result<?> districuteDemand(@RequestParam("id") String id,
			@RequestParam("procedureCount") Integer count,
			@RequestParam("dateStr") String dateStr){
		try {
			return planService.distributeDemand(id,count,dateStr);
		} catch (Exception e) {
			return Result.error("分配失败");
		}
	}
	
	@RequestMapping("/getPlansByDemandForm")
	@ResponseBody
	public Result<Set<PlanVo>> getPlansByDemandForm(DemandFormVo demandFormVo){
		try {
			return planService.getPlansByDemandForm(demandFormVo);
		} catch (Exception e) {
			return Result.error("获取失败");
		}
	}
	
	@RequestMapping("/getPlanPageByCriteria")
	@ResponseBody
	public Result<PageVo<PlanVo>> getPlanPageByCriteria(PlanVo planVo,CriteriaVo<PlanVo> criteria){
		criteria.setEntityVo(planVo);
		try {
			return planService.getPlanPageByCriteria(criteria);
		} catch (Exception e) {
			System.out.println(e);
			return Result.error("获取失败");
		}
	}
///多公司   代替上面的接口
	@RequestMapping("/getPlanPageByCriteriaAndCompany")
	@ResponseBody
	public Result<PageVo<PlanVo>> getPlanPageByCriteriaAndCompany(PlanVo planVo,CriteriaVo<PlanVo> criteria,String company_id){
		criteria.setEntityVo(planVo);
		try {
			return planService.getPlanPageByCriteriaAndCompany(criteria,company_id);
		} catch (Exception e) {
			System.out.println(e);
			return Result.error("获取失败");
		}
	}
	
	//
	@RequestMapping("/applyMaterial")
	@ResponseBody
	public Result<?> applyMaterial(@RequestParam("id") String id,
			@RequestParam("createdBy") String createdBy,
			@RequestParam("dateStr") String dateStr) {
		try {
			return planService.applyMaterial(id, createdBy, dateStr);
		} catch (Exception e) {
			return Result.error("申请失败");
		}
	}
	
	
}
