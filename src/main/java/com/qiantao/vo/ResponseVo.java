package com.qiantao.vo;

import lombok.Data;
@Data 
public class ResponseVo {
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

	
	
}
