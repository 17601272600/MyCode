package com.qiantao.mapper;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qiantao.domain.NoteTypeDomain;


public interface NoteTypeMapper extends JpaRepository<NoteTypeDomain,Long> {

	Long findByName(String name);

	
	
	//@Select({"select * from note_type where id=#{id}"})
	//NoteTypeDomain get(Long id);
	
	
	
}
