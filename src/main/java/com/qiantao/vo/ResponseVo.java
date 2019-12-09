package com.qiantao.vo;

import java.io.Serializable;

public class ResponseVo implements Serializable {
	Integer isSuc;
	
	String msg;
	
	Object data;

	public ResponseVo(int isSuc,String msg) {
		this(isSuc,msg,null);
	}

	public ResponseVo(int isSuc, String msg, Object data) {
		this.isSuc=isSuc;
		this.msg=msg;
		this.data=data;
	}

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
