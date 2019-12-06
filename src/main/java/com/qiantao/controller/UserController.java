package com.qiantao.controller;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qiantao.service.MsgService;
import com.qiantao.service.UserService;
import com.qiantao.util.RedisUtil;
import com.qiantao.vo.ResponseVo;

@RestController
@RequestMapping("/portal/user")
public class UserController extends BaseController {
	

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	UserService userService;
	
	@Resource
	MsgService msgService;
	
	@Resource
	RedisUtil redisUtil;
	
	@RequestMapping("/newAccount")
	public ResponseVo newAccount(HttpServletRequest request) {
		ResponseVo vo=null;
		try {
			String loginId=request.getParameter("loginId");
			String pwd=request.getParameter("passcode");
			vo=userService.createAccount(loginId,pwd);
		} catch (Exception e) {
			
			e.printStackTrace();
			LOG.error(e.getMessage(),e);
		}
		return vo;
	}
	
	@RequestMapping("/getCode")
	public ResponseVo getCode(String telephone) {
		ResponseVo vo=null;
		try {
			String code=getRandomString(11);
			msgService.sendCodeToTel(telephone, code);
			redisUtil.setCache(code,60l);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(),e);
		}
		return vo;
	}
	
	public static String getRandomString(int length){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
}
