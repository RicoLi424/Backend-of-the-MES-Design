package com.example.mes.plan.controller;

import com.alibaba.fastjson.JSON;
import com.example.mes.plan.common.Result;
import com.example.mes.plan.entity.Line;
import com.example.mes.plan.entity.Product;
import com.example.mes.plan.service.IDemandFormService;
import com.example.mes.plan.vo.CriteriaVo;
import com.example.mes.plan.vo.DemandFormVo;
import com.example.mes.plan.vo.PageVo;
import org.apache.ibatis.annotations.One;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/demandForm")
public class DemandFormHandler {

	@Autowired
	private IDemandFormService demandFormService;
	
	 @RequestMapping("/applyDeletion")
	 @ResponseBody
	 public Result<?> applyDemandForm(DemandFormVo demandFormVo){
		 
		 try {
			return demandFormService.applyDeletion(demandFormVo);
		} catch (Exception e) {
			return Result.error("申请失败");
		}
	 }
	 
	 @RequestMapping("/saveDemandForm")
	 @ResponseBody
	 public Result<?> saveDemandForm(DemandFormVo demandFormVo){
		 
		 try {
			 System.out.println(JSON.toJSONString(demandFormVo));
			 if (demandFormVo.getOriginalDemandForm() != null) {
				 return demandFormService.applyChange(demandFormVo);
			}else {
				return demandFormService.saveDemandForm(demandFormVo);
			}
		} catch (Exception e) {
		 	System.out.println(e);
			return Result.error("保存失败");
		}
	 }
	 
	 @RequestMapping("/getDemandFormById")
	 @ResponseBody
	 public Result<DemandFormVo> getDemandFormById(@RequestParam(name="id",required=true) String id){
		 try {
			return demandFormService.getDemandFormById(id);
		} catch (Exception e) {
			return Result.error("搜索失败");
		}
	 }
	 
	 @RequestMapping("/getDemandFormPageByCriteria")
	 @ResponseBody
	 public Result<PageVo<DemandFormVo>> getDemandFormPageByCriteria(DemandFormVo demandFormVo,CriteriaVo<DemandFormVo> criteriaVo){
		 criteriaVo.setEntityVo(demandFormVo);
		 try {
			return demandFormService.getDemandFormPageByCriteria(criteriaVo);
		} catch (Exception e) {
			return Result.error("搜索失败");
		}
	 }
	 
	 @RequestMapping("/getHistoryVersions")
	 @ResponseBody
	 public Result<List<DemandFormVo>> getHistoryVersions(DemandFormVo demandFormVo){
		 try {
			return demandFormService.getHistoryVersions(demandFormVo);
		} catch (Exception e) {
			return Result.error("搜索失败");
		}
	 }
	 
	 @RequestMapping("/permit")
	 @ResponseBody
	 public Result<?> permit(DemandFormVo demandFormVo){
		 try {
			if(demandFormVo.getDf().isApplyingDeletion()) {
				 return demandFormService.permitDeletion(demandFormVo);
			 }else {
				 return demandFormService.permitChange(demandFormVo);
			 }
		} catch (Exception e) {
			return Result.error("通过失败");
		}
	 }
	 
	 @RequestMapping("/reject")
	 @ResponseBody
	 public Result<?> reject(DemandFormVo demandFormVo){
		 try {
				if(demandFormVo.getDf().isApplyingDeletion()) {
					 return demandFormService.rejectDeletion(demandFormVo);
				 }else {
					 return demandFormService.rejectChange(demandFormVo);
				 }
			} catch (Exception e) {
				return Result.error("通过失败");
			}
	 }
	 
	 @RequestMapping("/getLinesByProduct")
	 @ResponseBody
	 public Result<Set<Line>> getLinesByProduct(Product product) {
		 try
		{
			return demandFormService.getLinesByProduct(product);
		}
		catch (Exception e)
		{
			return Result.error("检索失败");
		}
	 }
	 
//	 @RequestMapping("/test")
//	 @ResponseBody
//	 public void test(DemandFormVo demandFormVo){
//		 System.out.println(demandFormVo.getCreatedTime());
//		 
//	 }
}
