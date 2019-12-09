package com.qiantao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qiantao.domain.NoteTypeDomain;

@Mapper
public interface NoteTypeMapper  extends BaseMapper{

	@Insert({"insert into note_type(name,`desc`,delflag) values (#{name},#{desc},0)"})
	@Options(useGeneratedKeys = true, keyProperty="id", keyColumn="id")
	Long insert(NoteTypeDomain domain);
	
	@Update({"update note_type set name=#{name},desc=#{desc} where id=#{id}"})
	int update(NoteTypeDomain domain);	
	
	@Delete({"delete from note_type where id=#{id}"})
	boolean delete(Long id);
	
	@Select({"select * from note_type where id=#{id}"})
	NoteTypeDomain get(Long id);
	
	@Select({"select id from note_type where name=#{name} limit 1"})
	Long checkNameExist(String name);
	
}
