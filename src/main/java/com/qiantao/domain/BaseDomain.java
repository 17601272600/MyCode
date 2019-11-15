package com.qiantao.domain;

import java.sql.Date;

public class BaseDomain {
	Long id;
	
	Integer delfalg;
	
	Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDelfalg() {
		return delfalg;
	}

	public void setDelfalg(Integer delfalg) {
		this.delfalg = delfalg;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
