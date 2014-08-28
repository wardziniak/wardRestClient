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

public class DefaultRestClient extends RestClient {
	
	private HttpClient httpClient = HttpClients.createDefault();
	
	//private final String host;
	
	//private static WardRestClient wardClient = null;
	
	public static final int TIMEOUT = 3000;
	
	protected DefaultRestClient(String host) {
		this.setHostname(host);
	}
	
	@Override
	public synchronized <T> Response<T> execute(Request request, Class<T> type) throws ClientProtocolException, IOException {
//		HttpParams params = httpClient.getParams();
//		HttpConnectionParams.setConnectionTimeout(params, TIMEOUT);
//		HttpConnectionParams.setSoTimeout(params, TIMEOUT);
		HttpRequestBase httpRequestBase = request.parseToHttpRequest();
		httpRequestBase.setURI(URI.create(this.createRequestUri(request)));
		HttpResponse httpResponse = httpClient.execute(httpRequestBase);
		return request.parseResponse(httpResponse, type);
	}
	

}
