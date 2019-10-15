package com.qiantao.service;


public interface BaseService {

	Object getModel(Long id);
	
	Object getModel(Long[] ids);
	
    Object get(Long id);
    
    Object saveOrUpdate(Object model);

    void delete(Long[] ids);

    void delete(Long id);
    
    
    


}
