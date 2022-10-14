package com.example.mes.plan.dao;

import com.example.mes.plan.common.MesBaseMapper;
import com.example.mes.plan.entity.DemandForm;
import com.example.mes.plan.entity.Line;
import com.example.mes.plan.entity.Product;
import com.example.mes.plan.vo.CriteriaVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
@Repository
public interface DemandFormMapper extends MesBaseMapper<DemandForm> {
	
	List<DemandForm> getDemandFormByCriteria(CriteriaVo<DemandForm> criteria);

	Integer getCountByCriteria(CriteriaVo<DemandForm> criteria);

//	void updateDemandForm(DemandForm demandForm);
	
	void updateOriginalDemandForm(@Param("df")DemandForm demandForm);

	void updateReadTime(@Param("df")DemandForm demandForm);

	void updateWaiting(@Param("df")DemandForm demandForm);

	List<DemandForm> selectByOriginalDemandFormId(@Param("df")DemandForm demandForm);
	
	void updateDeleteSignal(@Param("id")String id);
	
	Set<Line> getLinesByProduct(@Param("product")Product product);
}
