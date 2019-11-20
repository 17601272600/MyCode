package com.qiantao.controller;

import java.util.Enumeration;
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
		
			String url="http://oauth/oauth/account/regeist";
			Map<String,String> map=new HashMap<String,String>();
			map.put("loginId",request.getParameter("loginId"));
			map.put("password",request.getParameter("passcode"));
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
	@RequestMapping("/text")
	public String text(HttpServletRequest request,String telephone) {
		System.out.println(telephone);
		System.out.println("telephone by mvn "+telephone);
		System.out.println("telephone by attr"+request.getAttribute("telephone"));
		System.out.println("telephone by param"+request.getParameter("telephone"));
		System.out.println("Attributions:");
		 Enumeration<String>  attnames=request.getAttributeNames();
		while (attnames.hasMoreElements()) {
			String string = (String) attnames.nextElement();
			System.out.println("attr:"+request.getAttribute(string));
		}
		System.out.println("end");
		System.out.println("Parameter:");
		attnames=request.getParameterNames();
		
		while (attnames.hasMoreElements()) {
			String string = (String) attnames.nextElement();
			System.out.println("attr:"+request.getParameter(string));
		}
		System.out.println("end");
		
		return null;
	}
}
