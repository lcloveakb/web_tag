package org.meyi.qq.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.meyi.qq.model.PageBean;

public interface BaseDao<T> {
	public void save(T t);

	public void update(T t);
	
	public void merge(T t);
	public T getById(Integer id);

	public List<T> queryAll();
	
	public PageBean pageOfList(Integer pageNo,Integer pageSize);
	public PageBean pageOfWhere(Integer pageNo, Integer pageSize,String whereSql, Object...params);
    public void delete(Integer id);
    
    public  Session getSession();

	public T getById(String id);
	
	/**
	 * sql查列表 + 分页
	 * 
	 * @param sql
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Map> findBySql(String sql, int pageNo, int pageSize);
	/**
	 * sql查列表 + 分页 + 条件查询
	 * 
	 * @param sql
	 * @param params
	 * @param pageNo
	 * @param pageSzie
	 * @return
	 */
	public List<Map> findBySql(String sql, Map<String, Object> params, int pageNo, int pageSzie);
    
}
