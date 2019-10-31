package com.qiantao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiantao.service.BaseService;
@Controller
public class BaseController {
	
	private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired
	BaseService baseService;
	
	@ResponseBody
	@RequestMapping("/actuator/info")
	public String info(){
		baseService.getModel(1l);
		LOG.info("asdds");
		return "接口介绍";
	}

}
