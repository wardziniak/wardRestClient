package com.wardziniak.jsonRestClient;

import org.apache.http.HttpStatus;

import android.util.Log;



public class Response<T> {

	private static final String TAG = "TradeShow:Response";
	
	public static final int EXCEPTION_STATUS = -1;
	
	public static final int APPLICATION_ERROR_STATUS = -100;
	
	private T resource;
	
	private int statusCode = HttpStatus.SC_OK;
	
	private String exceptionMessage;
	
    public static <T> Response<T> success(T result) {
        return new Response<T>(result);
    }
    
    public static <T> Response<T> error(Exception ex) {
    	ex.printStackTrace();
    	return new Response<T>(ex);
    }
    
    public static <T> Response<T> error(int statusCode) {
    	Log.w(TAG, "statusCode:" + statusCode);
    	return new Response<T>(statusCode);
    }
    
    public static <T> Response<T> error(String errorMessage) {
    	Log.w(TAG, "errorMessage:" + errorMessage);
    	return new Response<T>(errorMessage);
    }
    
    public static <T> Response<T> timeoutError() {
    	return new Response<T>(HttpStatus.SC_GATEWAY_TIMEOUT);
    }
    
    private Response(int statusCode) {
    	this.statusCode = statusCode;
    }
    
    private Response(Exception ex) {
      	this.exceptionMessage = ex.getClass().getName();
      	this.statusCode = EXCEPTION_STATUS; 	
    }
    
    private Response(String errorMessage) {
    	this.exceptionMessage = errorMessage;
    	this.statusCode = APPLICATION_ERROR_STATUS;
    }
    
    private Response (T resource) {
    	this.resource = resource;
    }
    
    public T getResourcse() {
    	return resource;
    }

	public int getStatusCode() {
		return statusCode;
	}
	
	public String getExceptionMessage() {
		return this.exceptionMessage;
	}
	
	public String getError() {
		return ((statusCode == EXCEPTION_STATUS) || (statusCode == APPLICATION_ERROR_STATUS) ? this.exceptionMessage : "" + statusCode);
	}

	public void setResource(T resource) {
		this.resource = resource;
	}

}
