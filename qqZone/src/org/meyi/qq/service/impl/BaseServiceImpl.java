package org.meyi.qq.service.impl;

import java.util.List;

import org.meyi.qq.dao.BaseDao;
import org.meyi.qq.model.PageBean;
import org.meyi.qq.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {
  
	@Autowired
	protected BaseDao<T> baseDao;
	
	
	@Override
	public void save(T t) {
		baseDao.save(t);
	}
	

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public void merge(T t) {
		baseDao.merge(t);
	}

	@Override 
	public T getById(Integer id) {
		return baseDao.getById(id);
	}
	
	@Override
	public T getById(String id) {
		return baseDao.getById(id);
	}

	@Override
	public List<T> queryAll() {
		return baseDao.queryAll();
	}

	@Override
	public PageBean pageOfList(Integer pageNo, Integer pageSize) {
		return baseDao.pageOfList(pageNo, pageSize);
	}

	@Override
	public PageBean pageOfWhere(Integer pageNo, Integer pageSize,
			String whereSql, Object... params) {
		return baseDao.pageOfWhere(pageNo, pageSize, whereSql, params);
	}

	@Override
	public void delete(Integer id) {
		baseDao.delete(id);
	}


	


	

	
	
}
