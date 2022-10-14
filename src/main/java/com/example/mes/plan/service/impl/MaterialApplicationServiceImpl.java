package com.example.mes.plan.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mes.plan.service.IMaterialApplicationService;
import com.example.mes.plan.vo.MaterialApplicationVo;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service("materialApplicationService")
public class MaterialApplicationServiceImpl implements IMaterialApplicationService {

	@Override
	public boolean save(MaterialApplicationVo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveBatch(Collection<MaterialApplicationVo> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdateBatch(Collection<MaterialApplicationVo> entityList, int batchSize) {
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
	public boolean remove(Wrapper<MaterialApplicationVo> queryWrapper) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeByIds(Collection<? extends Serializable> idList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateById(MaterialApplicationVo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(MaterialApplicationVo entity, Wrapper<MaterialApplicationVo> updateWrapper) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBatchById(Collection<MaterialApplicationVo> entityList, int batchSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate(MaterialApplicationVo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MaterialApplicationVo getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<MaterialApplicationVo> listByIds(Collection<? extends Serializable> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<MaterialApplicationVo> listByMap(Map<String, Object> columnMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MaterialApplicationVo getOne(Wrapper<MaterialApplicationVo> queryWrapper, boolean throwEx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getMap(Wrapper<MaterialApplicationVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <V> V getObj(Wrapper<MaterialApplicationVo> queryWrapper, Function<? super Object, V> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(Wrapper<MaterialApplicationVo> queryWrapper) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MaterialApplicationVo> list(Wrapper<MaterialApplicationVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPage<MaterialApplicationVo> page(IPage<MaterialApplicationVo> page,
			Wrapper<MaterialApplicationVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> listMaps(Wrapper<MaterialApplicationVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <V> List<V> listObjs(Wrapper<MaterialApplicationVo> queryWrapper, Function<? super Object, V> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPage<Map<String, Object>> pageMaps(IPage<MaterialApplicationVo> page,
			Wrapper<MaterialApplicationVo> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseMapper<MaterialApplicationVo> getBaseMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
