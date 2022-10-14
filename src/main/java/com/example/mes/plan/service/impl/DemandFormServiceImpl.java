package com.example.mes.plan.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mes.plan.common.Result;
import com.example.mes.plan.dao.DemandFormMapper;
import com.example.mes.plan.entity.DemandForm;
import com.example.mes.plan.entity.Line;
import com.example.mes.plan.entity.Product;
import com.example.mes.plan.service.IDemandFormService;
import com.example.mes.plan.vo.CriteriaVo;
import com.example.mes.plan.vo.DemandFormVo;
import com.example.mes.plan.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;

@Service("demandFormService")
public class DemandFormServiceImpl implements IDemandFormService {

	@Autowired
	private DemandFormMapper demandFormMapper;

	@Override
	@Transactional
	public Result<PageVo<DemandFormVo>> getDemandFormPageByCriteria(CriteriaVo<DemandFormVo> criteria) {
		
		criteria.getEntityVo().setNo("%"+criteria.getEntityVo().getNo()+"%");
		
		CriteriaVo<DemandForm> criteriaVo = 
				new CriteriaVo<DemandForm>(criteria.getEntityVo().getDf(), 
						criteria.getPageNo(), criteria.getPageSize(), 
						criteria.getBeginTimestamp(), criteria.getEndTimestamp(),criteria.getCompany_id());
		
		List<DemandForm> list = demandFormMapper.getDemandFormByCriteria(criteriaVo);
		
		List<DemandFormVo> arrayList = new ArrayList<>();
		for (DemandForm demandForm : list) {
			arrayList.add(new DemandFormVo(demandForm));
		}
		
		int count = demandFormMapper.getCountByCriteria(criteriaVo);
		
		int pageCount = (int)Math.ceil((double)count/criteriaVo.getPageSize());
		int pageSize = criteriaVo.getPageSize();
		int current = criteriaVo.getPageNo();
		PageVo<DemandFormVo> page = new PageVo<DemandFormVo>(count, pageSize, pageCount, current,arrayList );
		return Result.ok(page);
	}

	@Override
	@Transactional
	public Result<?> applyDeletion(DemandFormVo demandForm) {

		String demandFormId = demandForm.getDf().getId();
		DemandForm selectDemandForm = demandFormMapper.selectById(demandFormId);
		DemandForm originalDemandForm = selectDemandForm.getOriginalDemandForm();

		if (originalDemandForm!=null&&originalDemandForm.getId().equals("0"))
			return Result.error("重复申请");

		demandFormMapper.updateDeleteSignal(demandFormId);
//		demandFormMapper.updateStatus(demandFormId, "0");
		return Result.ok();

	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public Result<?> saveDemandForm(DemandFormVo demandForm) {
		demandForm.setId(UUID.randomUUID().toString().replace("-", ""));
		
		DemandForm target = demandForm.getDf();
		target.setCompany_id(demandForm.getCompany_id());
		target.getExpectedDate().setDate(target.getExpectedDate().getDate()+1);
		demandFormMapper.insert(target);
		
		return Result.ok();
	}
	
	@Override
	@Transactional
	public Result<?> applyChange(DemandFormVo demandFormVo) {
		demandFormVo.setId(UUID.randomUUID().toString().replace("-", ""));
		
		demandFormMapper.insert(demandFormVo.getDf());
		DemandForm originalDemandForm = demandFormVo.getOriginalDemandForm();
		originalDemandForm.setWaiting(false);
		demandFormMapper.updateWaiting(originalDemandForm);
		
		return Result.ok();
	}
	

	@Override
	@Transactional
	public Result<DemandFormVo> getDemandFormById(String id) {
		DemandFormVo dfvo = new DemandFormVo(demandFormMapper.selectById(id));
		return Result.ok(dfvo);
	}

	@Override
	@Transactional
	public Result<?> permitDeletion(DemandFormVo demandForm) {
		demandForm.getDf().setWaiting(false);
		
		demandFormMapper.updateReadTime(demandForm.getDf());
		demandFormMapper.updateWaiting(demandForm.getDf());
		demandFormMapper.updateDeleted(demandForm.getDf().getId(), "1");
		return Result.ok();
	}

	@Override
	@Transactional
	public Result<?> permitChange(DemandFormVo demandForm) {
	
		demandFormMapper.updateReadTime(demandForm.getDf());
		
		//获取修改前最新版本
		DemandForm oldForm = demandFormMapper.selectById(demandForm.getDf().getOriginalDemandForm().getId());
		//获取修改前最新版本的历史版本
		List<DemandForm> list = demandFormMapper.selectByOriginalDemandFormId(oldForm);
		
//		遍历历史版本
		for (DemandForm df : list) {
//			修改指向
			df.setOriginalDemandForm(demandForm.getDf());
			demandFormMapper.updateOriginalDemandForm(df);
		}
		
//		批准修改的版本成为最新版本
		demandForm.getDf().setOriginalDemandForm(null);
		demandFormMapper.updateOriginalDemandForm(demandForm.getDf());
		
//		修改前的最新版本 指向 现在的最新版本
		oldForm.setOriginalDemandForm(demandForm.getDf());
		oldForm.setWaiting(false);
		demandFormMapper.updateOriginalDemandForm(oldForm);
		demandFormMapper.updateWaiting(oldForm);
		
		return Result.ok();
	}

	@Override
	@Transactional
	public Result<?> rejectDeletion(DemandFormVo demandForm) {

		demandForm.getDf().setOriginalDemandForm(null);
		demandFormMapper.updateOriginalDemandForm(demandForm.getDf());
		return Result.ok();
	}

	@Override
	@Transactional
	public Result<?> rejectChange(DemandFormVo demandForm) {

		DemandForm originalDemandForm = demandForm.getDf().getOriginalDemandForm();
		originalDemandForm.setWaiting(true);
		demandFormMapper.updateWaiting(originalDemandForm);
		
		demandForm.getDf().setWaiting(false);
		demandFormMapper.updateReadTime(demandForm.getDf()	);
		demandFormMapper.updateWaiting(demandForm.getDf());
		return Result.ok();
	}
	
	@Override
	@Transactional
	public Result<List<DemandFormVo>> getHistoryVersions(DemandFormVo demandForm) {

		List<DemandForm> dfList = demandFormMapper.selectByOriginalDemandFormId(demandForm.getDf());
		
		List<DemandFormVo> dfVoList = new ArrayList<>();
		for(DemandForm df : dfList) {
			dfVoList.add(new DemandFormVo(df));
		}
		
		return Result.ok(dfVoList );
	}

	@Override
	@Transactional
	public Result<Set<Line>> getLinesByProduct(Product product)
	{
		Set<Line> set = demandFormMapper.getLinesByProduct(product);
		return Result.ok(set);
	}
	
//***************************************************************************************

	@Override
	public boolean save(DemandFormVo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveBatch(Collection<DemandFormVo> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdateBatch(Collection<DemandFormVo> entityList, int batchSize) {
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
	public boolean remove(Wrapper<DemandFormVo> queryWrapper) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeByIds(Collection<? extends Serializable> idList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateById(DemandFormVo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(DemandFormVo entity, Wrapper<DemandFormVo> updateWrapper) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBatchById(Collection<DemandFormVo> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate(DemandFormVo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DemandFormVo getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DemandFormVo> listByIds(Collection<? extends Serializable> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DemandFormVo> listByMap(Map<String, Object> columnMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DemandFormVo getOne(Wrapper<DemandFormVo> queryWrapper, boolean throwEx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getMap(Wrapper<DemandFormVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <V> V getObj(Wrapper<DemandFormVo> queryWrapper, Function<? super Object, V> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(Wrapper<DemandFormVo> queryWrapper) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DemandFormVo> list(Wrapper<DemandFormVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPage<DemandFormVo> page(IPage<DemandFormVo> page, Wrapper<DemandFormVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> listMaps(Wrapper<DemandFormVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <V> List<V> listObjs(Wrapper<DemandFormVo> queryWrapper, Function<? super Object, V> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPage<Map<String, Object>> pageMaps(IPage<DemandFormVo> page, Wrapper<DemandFormVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseMapper<DemandFormVo> getBaseMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
