package com.example.mes.plan.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mes.plan.common.Result;
import com.example.mes.plan.dao.DemandFormMapper;
import com.example.mes.plan.dao.MaterialApplicationMapper;
import com.example.mes.plan.dao.PlanMapper;
import com.example.mes.plan.dao.ProcessMapper;
import com.example.mes.plan.entity.Process;
import com.example.mes.plan.entity.*;
import com.example.mes.plan.service.IPlanService;
import com.example.mes.plan.vo.CriteriaVo;
import com.example.mes.plan.vo.DemandFormVo;
import com.example.mes.plan.vo.PageVo;
import com.example.mes.plan.vo.PlanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;

@Service("planService")
public class PlanServiceImpl implements IPlanService {

	@Autowired
	private PlanMapper planMapper;
	@Autowired
	private ProcessMapper processMapper;
	@Autowired
	private MaterialApplicationMapper maMapper;
	@Autowired
	private DemandFormMapper dfMapper;

	/*
	 * @Autowired private ProcedureMapper procedureMapper;
	 */
	@Override
	@Transactional
	public Result<?> deletePlan(String id) {

		planMapper.deleteById(id);
		return Result.ok();
	}

	@Override
	@Transactional
	public Result<List<PlanVo>> queryLoad(String productionLineId) {

		List<Plan> list = planMapper.getPlansByProductionLineId(productionLineId);

		List<PlanVo> resultList = new ArrayList<>();

		for (Plan plan : list) {
			if (!plan.isEachProcessFinished()) {
				resultList.add(new PlanVo(plan));
			}
		}

		return Result.ok(resultList);
	}

	@Override
	@Transactional
	public Result<?> savePlan(PlanVo plan) {
		plan.getPlan().setId(UUID.randomUUID().toString().replace("-", ""));

		planMapper.insert(plan.getPlan());

		return Result.ok();
	}

	@Override
	@Transactional
	public Result<?> distributeDemand(String id, Integer count, String dateStr) {

		DemandForm df = dfMapper.selectById(id);

		for (Plan plan : df.getPlanSet()) {
			planMapper.updateDistributeTime(plan.getId());

			for (int i = 0; i < count; i++) {
				String uuid = UUID.randomUUID().toString().replace("-", "");
				String now = Instant.now().toEpochMilli() + "";
				String no = "19" + dateStr + now.substring(now.length() - 8);
				Process process = new Process(uuid, "1", plan.getCreatedBy(), i, plan.getExpectedQuantity(), plan);
				process.setNo(no);

				processMapper.insert(process);
			}
		}

		df.setWaiting(false);
		dfMapper.updateWaiting(df);

		return Result.ok();
	}

	@Override
	public Result<Set<PlanVo>> getPlansByDemandForm(DemandFormVo demandFormVo) {

		Set<Plan> planSet = planMapper.getPlansByDemandFormId(demandFormVo.getId());

		Set<PlanVo> hashSet = new HashSet<>();
		for (Plan plan : planSet) {
			hashSet.add(new PlanVo(plan));
		}

		return Result.ok(hashSet);
	}



	@Override
	@Transactional
	public Result<PageVo<PlanVo>> getPlanPageByCriteria(CriteriaVo<PlanVo> criteria) {

		CriteriaVo<Plan> criteriaVo = new CriteriaVo<>(criteria.getEntityVo().getPlan(), criteria.getPageNo(),
				criteria.getPageSize(), criteria.getBeginTimestamp(), criteria.getEndTimestamp(),criteria.getCompany_id());
		List<Plan> list = planMapper.getPlanByCriteria(criteriaVo);

		List<PlanVo> arrayList = new ArrayList<>();
		for (Plan plan : list) {
			arrayList.add(new PlanVo(plan));
		}

		int count = planMapper.getCountByCriteria(criteriaVo);

		int pageCount = (int) Math.ceil((double) count / criteriaVo.getPageSize());
		int pageSize = criteriaVo.getPageSize();
		int current = criteriaVo.getPageNo();
		PageVo<PlanVo> page = new PageVo<>(count, pageSize, pageCount, current, arrayList);
		return Result.ok(page);

	}


	@Override
	public Result<PageVo<PlanVo>> getPlanPageByCriteriaAndCompany(CriteriaVo<PlanVo> criteria, String company_id) {

		CriteriaVo<Plan> criteriaVo = new CriteriaVo<>(criteria.getEntityVo().getPlan(), criteria.getPageNo(),
				criteria.getPageSize(), criteria.getBeginTimestamp(), criteria.getEndTimestamp());
		List<Plan> list = planMapper.getPlanByCriteria(criteriaVo);

		List<PlanVo> arrayList = new ArrayList<>();
		for (Plan plan : list) {
			arrayList.add(new PlanVo(plan));
		}

		int count = planMapper.getCountByCriteria(criteriaVo);

		int pageCount = (int) Math.ceil((double) count / criteriaVo.getPageSize());
		int pageSize = criteriaVo.getPageSize();
		int current = criteriaVo.getPageNo();
		PageVo<PlanVo> page = new PageVo<>(count, pageSize, pageCount, current, arrayList);
		return Result.ok(page);
	}

	@Override
	@Transactional
	public Result<?> applyMaterial(String id, String createdBy,String dateStr) {

		Plan plan = planMapper.selectById(id);
		DemandForm df = dfMapper.selectById(plan.getDemandForm().getId());
		Product product = df.getProduct();
		
		String productId = product.getId();
		Set<String> set = maMapper.selectMaterialIds(productId);
		
		for (String materialId: set) {
			
			String uuid = UUID.randomUUID().toString().replace("-", ""); // 给物料申请单生成主键
//			String now = Instant.now().toEpochMilli() + "";
//			String no = "20" + dateStr + now .substring(now.length() - 8);
			Integer quantity = maMapper.selectMaterialCount(productId, materialId);
			MaterialApplication ma = new MaterialApplication
					(uuid, "1", createdBy, quantity*plan.getExpectedQuantity() , plan, materialId);
//			ma.setNo(no);
			maMapper.insert(ma);
		}

		return Result.ok();
	}

//********************************************************************************************************
	@Override
	public boolean save(PlanVo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveBatch(Collection<PlanVo> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdateBatch(Collection<PlanVo> entityList, int batchSize) {
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
	public boolean remove(Wrapper<PlanVo> queryWrapper) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeByIds(Collection<? extends Serializable> idList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateById(PlanVo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PlanVo entity, Wrapper<PlanVo> updateWrapper) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBatchById(Collection<PlanVo> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate(PlanVo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PlanVo getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<PlanVo> listByIds(Collection<? extends Serializable> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<PlanVo> listByMap(Map<String, Object> columnMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanVo getOne(Wrapper<PlanVo> queryWrapper, boolean throwEx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getMap(Wrapper<PlanVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <V> V getObj(Wrapper<PlanVo> queryWrapper, Function<? super Object, V> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(Wrapper<PlanVo> queryWrapper) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PlanVo> list(Wrapper<PlanVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPage<PlanVo> page(IPage<PlanVo> page, Wrapper<PlanVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> listMaps(Wrapper<PlanVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <V> List<V> listObjs(Wrapper<PlanVo> queryWrapper, Function<? super Object, V> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPage<Map<String, Object>> pageMaps(IPage<PlanVo> page, Wrapper<PlanVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseMapper<PlanVo> getBaseMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
