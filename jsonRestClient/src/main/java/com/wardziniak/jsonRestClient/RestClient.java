package com.wardziniak.jsonRestClient;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public abstract class RestClient {
	
	private String hostname;
	
	public abstract <T> Response<T> execute(Request request, Class<T> type) throws ClientProtocolException, IOException;
	
	public final void setHostname(String hostname) {
		this.hostname = hostname;
	}

	protected final String createRequestUri(Request request) {
		return this.hostname + request.getPath();
	}
	
	
}
