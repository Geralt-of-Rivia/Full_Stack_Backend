package com.wipro.Full_Stack_BackEnd;

public class AuthenticationBean {
	public AuthenticationBean(String msg) {
		super();
		this.msg = msg;
	}

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ShowBean [msg=" + msg + "]";
	}
	

}
