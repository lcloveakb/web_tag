package org.meyi.qq.service.impl;

import java.util.List;
import java.util.Map;

import org.meyi.qq.dao.UrlDao;
import org.meyi.qq.model.UrlTag;
import org.meyi.qq.service.UrlService;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl extends BaseServiceImpl<UrlTag> implements UrlService {

	public UrlDao getDao(){
		return (UrlDao) baseDao;
	}

	@Override
	public List<Map> findBySql(String sql, Map<String, Object> params, int pageNo, int pageSzie) {
		// TODO Auto-generated method stub
		return getDao().findBySql(sql, params, pageNo, pageSzie);
	}
	
	@Override
	public List<Map> findBySql(String sql, int pageNo, int pageSzie) {
		// TODO Auto-generated method stub
		return getDao().findBySql(sql, pageNo, pageSzie);
	}
}
