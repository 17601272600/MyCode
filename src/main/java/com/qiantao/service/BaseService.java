package com.qiantao.service;

import com.qiantao.domain.BaseDomain;
import com.qiantao.mapper.BaseMapper;

public interface BaseService<T extends BaseDomain>{

	T getModel(Long id);
	
	BaseMapper getMapper();
    

    void delete(Long ... id);

	boolean saveOrUpdate(T domain);

	boolean update(T domain); 


}
