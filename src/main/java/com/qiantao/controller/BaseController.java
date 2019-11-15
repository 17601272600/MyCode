package com.qiantao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController {
	
	
	@ResponseBody
	@RequestMapping("/actuator/info")
	public String info(){
//		baseService.getModel(1l);
		return "接口介绍";
	}

	
	
}
