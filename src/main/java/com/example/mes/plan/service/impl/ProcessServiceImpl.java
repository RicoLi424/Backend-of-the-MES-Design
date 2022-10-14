package com.example.mes.plan.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mes.plan.common.Result;
import com.example.mes.plan.dao.ProcessMapper;
import com.example.mes.plan.entity.Process;
import com.example.mes.plan.service.IProcessService;
import com.example.mes.plan.vo.PlanVo;
import com.example.mes.plan.vo.ProcessVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service("processService")
public class ProcessServiceImpl implements IProcessService {

	
	@Autowired
	private ProcessMapper processMapper ;
	
	
	@Override
	public Result<?> materialArrive(String id) {
		
		processMapper.updateMaterialArriveTime(id);
		return Result.ok();
	}

	@Override
	public Result<?> increaseProduct(String id, Integer count) {

		Process process = processMapper.selectById(id);
		
		int producedQuantity = process.getProducedQuantity()+count;
		process.setProducedQuantity(producedQuantity);
		processMapper.updateProducedQuantity(process);
		if(producedQuantity==process.getDemandQuantity()) {
			processMapper.updateFinishTime(process);
		}
		return Result.ok();
	}
	
	@Override
	public Result<List<ProcessVo>> getProcessesByPlan(PlanVo planVo) {
		List<Process> list = processMapper.selectByPlanId(planVo.getId());
		
		List<ProcessVo> resultList = new ArrayList<>();
		for (Process process : list) {
			resultList.add(new ProcessVo(process));
		}
		return Result.ok(resultList);
	}


	
//****************************************************************************************************
	@Override
	public boolean save(ProcessVo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveBatch(Collection<ProcessVo> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdateBatch(Collection<ProcessVo> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeById(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeByMap(Map<String, Object> columnMap) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Wrapper<ProcessVo> queryWrapper) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeByIds(Collection<? extends Serializable> idList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateById(ProcessVo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ProcessVo entity, Wrapper<ProcessVo> updateWrapper) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBatchById(Collection<ProcessVo> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate(ProcessVo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProcessVo getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ProcessVo> listByIds(Collection<? extends Serializable> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ProcessVo> listByMap(Map<String, Object> columnMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProcessVo getOne(Wrapper<ProcessVo> queryWrapper, boolean throwEx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getMap(Wrapper<ProcessVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <V> V getObj(Wrapper<ProcessVo> queryWrapper, Function<? super Object, V> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(Wrapper<ProcessVo> queryWrapper) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProcessVo> list(Wrapper<ProcessVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPage<ProcessVo> page(IPage<ProcessVo> page, Wrapper<ProcessVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> listMaps(Wrapper<ProcessVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <V> List<V> listObjs(Wrapper<ProcessVo> queryWrapper, Function<? super Object, V> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPage<Map<String, Object>> pageMaps(IPage<ProcessVo> page, Wrapper<ProcessVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseMapper<ProcessVo> getBaseMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
	
}
