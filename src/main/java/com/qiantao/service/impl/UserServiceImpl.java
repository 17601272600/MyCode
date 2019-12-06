package com.qiantao.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qiantao.domain.BaseDomain;
import com.qiantao.domain.UserDomain;
import com.qiantao.mapper.BaseMapper;
import com.qiantao.service.UserService;
import com.qiantao.vo.ResponseVo;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService{
	//@Autowired
	//UserMapper userMapper;
	

	@Override
	public BaseMapper getMapper() {
		return null;
	}
	

	@Override
	public UserDomain getModel(Long id) {
		if(id==null)
			return null;
		BaseDomain domain=(BaseDomain)redisUtil.getModel(UserDomain.class+":"+id);
		if(domain==null) {
			return (UserDomain) getMapper().get(id);
		}else {
			return null;
		}
	}


	@Override
	@Transactional(propagation= Propagation.REQUIRED,readOnly=true)
	public ResponseVo createAccount(String loginId, String pwd) {
		//userMapper.checkAccountExist(loginId,pwd);
		
		return new ResponseVo(1,"登录成功","1234566");
	}



}
