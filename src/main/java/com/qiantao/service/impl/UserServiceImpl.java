package com.qiantao.service.impl;

import org.springframework.stereotype.Service;

import com.qiantao.domain.BaseDomain;
import com.qiantao.domain.UserDomain;
import com.qiantao.mapper.BaseMapper;
import com.qiantao.service.UserService;

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

}
