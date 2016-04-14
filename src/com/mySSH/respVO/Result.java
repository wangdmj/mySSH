package com.mySSH.respVO;



public class Result {
	private String status;
	private String mesg;
	private Object data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMesg() {
		return mesg;
	}
	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data){
		this.data=data;
	}
}
