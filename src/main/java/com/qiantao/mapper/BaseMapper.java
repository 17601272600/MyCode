package com.qiantao.mapper;


import com.qiantao.domain.BaseDomain;

public interface BaseMapper {
	
	public BaseDomain get(Long id);
	
	
	public boolean delete(Long id);
	
	
	public boolean update(BaseDomain domain);
	

	public boolean insert(BaseDomain domain);
	
}
