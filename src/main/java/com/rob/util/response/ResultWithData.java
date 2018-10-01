package com.rob.util.response;

public class ResultWithData{
	
	private Object data; //contains the response object
	private String status; //contains the response status message
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	

}
