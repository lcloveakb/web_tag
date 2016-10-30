package org.meyi.qq.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.meyi.qq.dao.BaseDao;
import org.meyi.qq.model.PageBean;
import org.springframework.transaction.annotation.Transactional;
@SuppressWarnings("unchecked")

@Transactional
public  class BaseDaoImpl<T> implements BaseDao<T> {

	    @Resource
		SessionFactory sessionFactory;
		
		
		
		private Class<T> clazz=null;
		

	
		public BaseDaoImpl(){
			//获得父类的类参数类型（泛型）
			ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
			clazz=(Class<T>)type.getActualTypeArguments()[0];
		}
	@Override
	public void save(T t) {
	 getSession().save(t);
	}

	@Override
	public void update(T t) {
	 getSession().update(t);	
	}
	
	@Override
	public void merge(T t) {
	 getSession().merge(t);
	}

	@Override
	public T getById(Integer id) {
	 return (T)getSession().get(clazz, id);
	}
	
	@Override
	public T getById(String id) {
	 return (T)getSession().get(clazz, id);
	}

	@Override
	public List<T> queryAll() {
	 return getSession().createQuery("FROM " + clazz.getSimpleName()).list();
	}

	@Override
	public void delete(Integer id) {
		//System.out.println(id);
		Object o=getSession().get(clazz, id);
		//System.out.println(((Leavemessage)o).getMessageId());
		if(o!=null){
			//System.out.println("in if");
			getSession().delete(o);
		}
	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public PageBean pageOfList(Integer pageNo, Integer pageSize) {
		List<T>pageList=this.getSession().createQuery("From "+clazz.getSimpleName())
		.setFirstResult((pageNo - 1) * pageSize)
		.setMaxResults(pageSize)
		.list();
	 return new PageBean(pageNo, pageSize, pageList, getCountData());
	}
	
	@Override
	public PageBean pageOfWhere(Integer pageNo, Integer pageSize,
			String whereSql, Object... params) {
		Query query=this.getSession().createQuery("From "+clazz.getSimpleName()+" "+whereSql);
		 for(int i=0;i<params.length;i++){
			query.setParameter(i, params[i]);
		 }
		 List<T>pageList=query.setFirstResult((pageNo - 1) * pageSize)
				 .setMaxResults(pageSize)
				 .list();
		 return new PageBean(pageNo, pageSize, pageList, getCountData(whereSql,params));
	}
	
	
	protected Integer getCountData(){
		 Long countData=(Long)this.getSession().createQuery("SELECT COUNT(*) FROM "+clazz.getSimpleName()).list().get(0);
		 return countData.intValue();
	}
	protected Integer getCountData(String wheresql,Object... params){
		Query query= this.getSession().createQuery("SELECT COUNT(*) FROM "+clazz.getSimpleName()+" "+wheresql);
		for(int i=0;i<params.length;i++){
			query.setParameter(i, params[i]);
		 }
		Long countData =(Long)query.list().get(0);
		return countData.intValue();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Map> findBySql(String sql, int pageNo, int pageSize) {
		return this.getSession().createSQLQuery(sql).setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageNo * pageSize).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}
	
	@Override
	public List<Map> findBySql(String sql, Map<String, Object> params, int pageNo, int pageSzie) {
		SQLQuery query =this.getSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return query.setFirstResult((pageNo - 1) * pageSzie).setMaxResults(pageNo * pageSzie)
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}
	
}