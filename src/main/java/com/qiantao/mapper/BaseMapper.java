package com.qiantao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface BaseMapper {
	
	@Select({"select * from disabled_employment limit 10"})
	public List<Map> getAll();
	

}
