package org.meyi.qq.service;


import java.util.List;

import org.meyi.qq.model.PageBean;



public interface BaseService<T> {
	public void save(T t);

	public void update(T t);
	
	public void merge(T t);
	
	public T getById(Integer id);

	public List<T> queryAll();
	
	public PageBean pageOfList(Integer pageNo,Integer pageSize);
	public PageBean pageOfWhere(Integer pageNo, Integer pageSize,String whereSql, Object...params);
    public void delete(Integer id);

	public T getById(String id);
    
	
}
