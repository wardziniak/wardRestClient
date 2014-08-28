package com.wardziniak.jsonRestClient;

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class WardRestClient {
	
	private HttpClient httpClient = HttpClients.createDefault();
	
	private final String host;
	
	private static WardRestClient wardClient = null;
	
	public static final int TIMEOUT = 3000;
	
	private WardRestClient(String host) {
		this.host = host;
	}
	
	public static synchronized WardRestClient getInstance(String host) {
		if (wardClient == null)
			wardClient = new WardRestClient(host);
		return wardClient;
	}
	
	
	public synchronized <T> Response<T> execute(Request request, Class<T> type) throws ClientProtocolException, IOException {
		HttpParams params = httpClient.getParams();
		HttpConnectionParams.setConnectionTimeout(params, TIMEOUT);
		HttpConnectionParams.setSoTimeout(params, TIMEOUT);
		HttpRequestBase httpRequestBase = request.parseToHttpRequest();
		httpRequestBase.setURI(URI.create(this.createRequestUri(request)));
		HttpResponse httpResponse = httpClient.execute(httpRequestBase);
		return request.parseResponse(httpResponse, type);
	}
	
	private String createRequestUri(Request request) {
		return this.host + request.getPath();
	}
	

}
