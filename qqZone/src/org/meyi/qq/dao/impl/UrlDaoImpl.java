package org.meyi.qq.dao.impl;


import org.meyi.qq.dao.UrlDao;
import org.meyi.qq.model.UrlTag;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UrlDaoImpl extends BaseDaoImpl<UrlTag> implements UrlDao {

}
