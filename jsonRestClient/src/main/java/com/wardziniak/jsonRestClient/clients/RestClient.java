package com.wardziniak.jsonRestClient.clients;

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;

import com.wardziniak.jsonRestClient.Request;
import com.wardziniak.jsonRestClient.Response;
import com.wardziniak.jsonRestClient.exceptions.CannotCreateRestClient;

public abstract class RestClient {
	
	protected HttpClient httpClient;
	
	private String hostname;
	
	protected abstract HttpClient createHttpClient() throws CannotCreateRestClient;
	
	protected RestClient() throws CannotCreateRestClient {
		httpClient = createHttpClient();
	}
	
	public synchronized <T> Response<T> execute(Request request, Class<T> type) throws ClientProtocolException, IOException {
		HttpRequestBase httpRequestBase = request.parseToHttpRequest();
		httpRequestBase.setURI(URI.create(this.createRequestUri(request)));
		setHttpRequestParameters(httpRequestBase);
		HttpResponse httpResponse = httpClient.execute(httpRequestBase);
		return request.parseResponse(httpResponse, type);
	}
	
	protected void setHttpRequestParameters(HttpRequestBase httpRequestBase) {}
	
	protected final void setHostname(String hostname) {
		this.hostname = hostname;
	}

	protected final String createRequestUri(Request request) {
		return this.hostname + request.getPath();
	}
	
	
}
