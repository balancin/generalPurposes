package br.com.balancin.amazingcep;

public class NSResponse {

	private int error;
	private String errorDescription;
	private Object responseObject;
	
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public Object getResponseObject() {
		return responseObject;
	}
	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}
	
}
