package com.qiantao.service.impl;

import javax.annotation.Resource;
import com.qiantao.domain.BaseDomain;
import com.qiantao.service.BaseService;
import com.qiantao.util.RedisUtil;

public abstract class BaseServiceImpl implements BaseService {
	
	@Resource
	public RedisUtil redisUtil;
	
	@Override
	public void delete(Long... ids) {
		for(Long id:ids) {
			BaseDomain domain=this.getModel(id);
			redisUtil.removeModel(domain);
			this.getMapper().delete(id);
		}
	}

	@Override
	public boolean update(BaseDomain domain) {
		boolean flag=this.getMapper().update(domain);
		redisUtil.removeModel(domain);
		return flag;
	}

	@Override
	public boolean saveOrUpdate(BaseDomain domain) {
		if(domain==null||domain.getId()<0) {
			return false;
		}else if(domain.getId()==0||domain.getId()==null) {
			return this.getMapper().insert(domain);
		}else {
			return update(domain);
		}
	}

}
