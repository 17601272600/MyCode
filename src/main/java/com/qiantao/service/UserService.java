package com.qiantao.service;

import com.qiantao.domain.UserDomain;
import com.qiantao.vo.ResponseVo;

public interface UserService extends BaseService {
	public UserDomain getModel(Long id);

	public ResponseVo createAccount(String loginId, String pwd);
}
