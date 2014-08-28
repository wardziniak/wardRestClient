package com.wardziniak.jsonRestClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;


public class Request {

	public static final String APPLICATION_JSON = "application/json";
	
	public static final String CHARSET = "UTF-8";
	
	private MethodType method;

	private String url;
	
	private String authorizationHeader;

	private JSONableRequestObject jsonable;

	public Request(String url, String authorizationHeader, JSONableRequestObject jsonable) { 
		this.method = jsonable.getMethodType();
		this.url = url;
		this.jsonable = jsonable;
		this.authorizationHeader = authorizationHeader;
		this.url += jsonable.getPathWithParameters();
	}
	
	public HttpRequestBase parseToHttpRequest() throws UnsupportedEncodingException {
		return method.createHttpUriRequest(this);
	}
	
	public <T> Response<T> parseResponse(HttpResponse httpResponse, Class<T> type) {
		try {
			final String jsonString = EntityUtils.toString(httpResponse.getEntity(), CHARSET);
			//final String jsonString = EntityUtils.toString(httpResponse.getEntity());
			//Log.d("TradeShow", "json:" + jsonString);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				Gson gson = new Gson();
				return Response.success(gson.fromJson(jsonString, type));
			}
			return Response.error(httpResponse.getStatusLine().getStatusCode());
			
		} catch (ParseException e) {
			e.printStackTrace();
			return Response.error(e);
		} catch (IOException e) {
			e.printStackTrace();
			return Response.error(e);
		}
	}
	
	public String getPath() {
		return null;
	}

	public MethodType getMethod() {
		return method;
	}

	public void setMethod(MethodType method) {
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public JSONableRequestObject getJsonable() {
		return jsonable;
	}

	public void setJsonable(JSONableRequestObject jsonable) {
		this.jsonable = jsonable;
	}
	
//	public String getAuthorizationHeader() {
//		return Helper.AUTHORIZATIO_TYPE + authorizationHeader;
//	}
}
