package com.qiantao.service;

import com.qiantao.domain.BaseDomain;
import com.qiantao.mapper.BaseMapper;

public interface BaseService{

	BaseDomain getModel(Long id);
	
	BaseMapper getMapper();
    

    void delete(Long ... id);

	boolean saveOrUpdate(BaseDomain domain);

	boolean update(BaseDomain domain); 


}
