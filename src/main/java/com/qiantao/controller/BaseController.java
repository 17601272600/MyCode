package com.qiantao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiantao.service.BaseService;
@Controller
public class BaseController {
	
	
	@Autowired
	BaseService baseService;
	
	@ResponseBody
	@RequestMapping("/actuator/info")
	public String info(){
		return "接口介绍";
	}
	
	@ResponseBody
	@GetMapping("/a")
	public String a() {
		System.out.println(baseService.getModel(1l));
		return "/aaa";
	}
}
