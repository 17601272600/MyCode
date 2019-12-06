package com.qiantao.mapper;

public interface UserMapper extends BaseMapper{

	void checkAccountExist(String loginId, String pwd);

}
