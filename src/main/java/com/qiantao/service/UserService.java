package com.qiantao.service;

import com.qiantao.domain.UserDomain;

public interface UserService extends BaseService {
	public UserDomain getModel(Long id);
}
