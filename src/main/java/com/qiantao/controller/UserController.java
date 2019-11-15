package com.qiantao.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qiantao.service.UserService;
import com.qiantao.vo.ResponseVo;

@RestController
@RequestMapping("/portal/user")
public class UserController extends BaseController {
	

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	UserService userService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/newAccount")
	public String newAccount(HttpServletRequest request) {
		
		try {
			;
			String url="http://OAUTH/oauth/account/regeist";
			Map<String,String> map=new HashMap<String,String>();
			String loginId=request.getParameter("telephone");
				String pwd=(String)	request.getAttribute("pwd");
			map.put("loginId",request.getParameter("loginId"));
			map.put("password",request.getParameter("pwd"));
			ResponseVo result=restTemplate.postForObject(url, map, ResponseVo.class);
			if(result.getIsSuc().equals(0)) {
				
				return "注冊成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(),e);
		}
		return "注冊失敗";
	}
}
