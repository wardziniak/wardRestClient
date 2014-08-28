package com.wardziniak.jsonRestClient;

import java.io.UnsupportedEncodingException;
import java.net.URI;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;

public enum MethodType {
	GET, POST, PUT, DELETE;

	public HttpRequestBase createHttpUriRequest(Request request) throws UnsupportedEncodingException {
		HttpRequestBase	httpRequestBase = null;
		switch (this) {
			case GET:
				httpRequestBase = new HttpGet();
				break;
			case DELETE:
				httpRequestBase = new HttpDelete();
				break;
			case POST:
				httpRequestBase = request.getJsonable().addToBody(new HttpPost());
				break;
			case PUT:
				httpRequestBase = request.getJsonable().addToBody(new HttpPut());
				break;
			default:
				throw new UnknownMethod();
		}
		//Log.d("tradeShow", "createHttpUriRequest:" + Helper.AUTHORIZATION_HEADER_LABEL + request.getAuthorizationHeader() + ":");
//		httpRequestBase.setHeader(Helper.AUTHORIZATION_HEADER_LABEL, request.getAuthorizationHeader());
//		httpRequestBase.setURI(URI.create(request.getUrl()));
		//httpRequestBase.addHeader("Content-type", "charset=utf-8");
		//httpRequestBase.addHeader("Content-type", "Content-type: application/json");
		return httpRequestBase;
	}	
}
