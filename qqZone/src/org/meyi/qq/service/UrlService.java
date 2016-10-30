package org.meyi.qq.service;

import java.util.List;
import java.util.Map;

import org.meyi.qq.model.UrlTag;

public interface UrlService extends BaseService<UrlTag> {

	public List<Map> findBySql(String sql, Map<String, Object> params, int pageNo, int pageSzie);
	public List<Map> findBySql(String sql, int pageNo, int pageSzie);
	
}
