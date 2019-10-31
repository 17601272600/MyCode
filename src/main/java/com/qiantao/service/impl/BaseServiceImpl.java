package com.qiantao.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiantao.mapper.BaseMapper;
import com.qiantao.service.BaseService;
@Service
public class BaseServiceImpl implements BaseService {

	@Resource
	BaseMapper baseMapper;
	@Override
	public Object getModel(Long id) {
		List list=baseMapper.getAll();
		return null;
	}

	@Override
	public Object getModel(Long[] ids) {
		return null;
	}

	@Override
	public Object get(Long id) {
		return null;
	}

	@Override
	public Object saveOrUpdate(Object model) {
		return null;
	}

	@Override
	public void delete(Long[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		
	}

}
