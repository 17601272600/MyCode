package com.qiantao.service.impl;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.qiantao.domain.NoteTypeDomain;
import com.qiantao.mapper.NoteTypeMapper;
import com.qiantao.service.NoteTypeService;
import com.qiantao.util.RedisUtil;
import com.qiantao.vo.ResponseVo;
@Service
public class NoteTypeServiceImpl  implements NoteTypeService{

	@Resource
	NoteTypeMapper noteTypeMapper;
	
	JpaRepository getMapper(){
		return noteTypeMapper;
	};
	
	@Resource
	RedisUtil RedisUtil;

	@Override
	public NoteTypeDomain getModel(Long id) {
	//	NoteTypeDomain domain=noteTypeMapper.getOne(id);
	//	if(domain==null) {
	//		System.out.println("  -----"+);
	//	}
		return null;

	}
	@SuppressWarnings("unchecked")
	public boolean saveOrUpdate(NoteTypeDomain domain) {
		boolean flag=false;
		if(domain==null) return flag;
		Object domain2=getMapper().save(domain);
		flag=domain2 != null;
		if(flag&&domain.getId()==0) {
			new RedisUtil().removeModel(domain.getClass()+":"+domain.getId());
		}
		return flag;
		
	}

	@Override
	public ResponseVo save(NoteTypeDomain domain) {
		Long isExist=noteTypeMapper.findByName(domain.getName());
		if(isExist==null) {
			this.saveOrUpdate(domain);
			return new ResponseVo(1, "保存成功",domain.getId());
		}else if(isExist.equals(domain.getId())){
			this.saveOrUpdate(domain);
			return new ResponseVo(1, "保存成功",isExist);
		}else {
			return new ResponseVo(0, "保存失败,已存在改类别");
		}
		
		
	}


}
