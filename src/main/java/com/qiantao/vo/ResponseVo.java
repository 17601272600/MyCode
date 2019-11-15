package com.qiantao.vo;

public class ResponseVo {
	Integer isSuc;
	
	String msg;
	
	Object data;

	public Integer getIsSuc() {
		return isSuc;
	}

	public void setIsSuc(Integer isSuc) {
		this.isSuc = isSuc;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
