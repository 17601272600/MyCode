package com.qiantao.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiantao.domain.NoteTypeDomain;
import com.qiantao.service.NoteTypeService;
import com.qiantao.vo.ResponseVo;

@RestController
@RequestMapping("/code/node")
public class NoteController {
	
	@Resource
	NoteTypeService NoteTypeService;
	
	
	@RequestMapping("/type/save")
	public ResponseVo saveOrUpdate(NoteTypeDomain domain) {
		return this.NoteTypeService.save(domain);
	}
	
	@RequestMapping("/getAllNoteData")
	public void getAllNoteData() {
		
	}

}
