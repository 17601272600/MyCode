package com.qiantao.service.impl;

import org.springframework.stereotype.Service;

import com.qiantao.service.MsgService;
@Service
public class MsgServiceImpl implements MsgService{

	@Override
	public void sendCodeToTel(String telephone,String code) {
		System.out.println("telephone:"+telephone+"code:"+code+"发送成功");
	}

	
}
