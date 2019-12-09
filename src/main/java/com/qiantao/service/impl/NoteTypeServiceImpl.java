package com.qiantao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiantao.domain.BaseDomain;
import com.qiantao.domain.NoteTypeDomain;
import com.qiantao.domain.UserDomain;
import com.qiantao.mapper.BaseMapper;
import com.qiantao.mapper.NoteTypeMapper;
import com.qiantao.service.NoteTypeService;
import com.qiantao.service.UserService;
import com.qiantao.vo.ResponseVo;
@Service
public class NoteTypeServiceImpl  extends BaseServiceImpl implements NoteTypeService{

	@Resource
	NoteTypeMapper noteTypeMapper;
	
	@Override
	public BaseMapper getMapper() {
		return noteTypeMapper;
	}

	@Override
	public NoteTypeDomain getModel(Long id) {
		if(id==null)
			return null;
		BaseDomain domain=(NoteTypeDomain)redisUtil.getModel(NoteTypeDomain.class+":"+id);
		if(domain==null) {
			domain= getMapper().get(id);
		}else {
			return null;
		}
		return (NoteTypeDomain)domain;
	}

	@Override
	public ResponseVo save(NoteTypeDomain domain) {
		Long isExist=noteTypeMapper.checkNameExist(domain.getName());
		if(domain.getId().equals(isExist)) {
			this.saveOrUpdate(domain);
			this.redisUtil.removeModel(domain);
			return new ResponseVo(1, "保存成功",domain.getId());
		}else if(domain.getId()==0&&isExist==null){
			this.saveOrUpdate(domain);
			this.redisUtil.removeModel(domain);
			return new ResponseVo(1, "保存成功",isExist);
		}else {
			return new ResponseVo(0, "保存失败,已存在改类别");
		}
		
		
	}


}
