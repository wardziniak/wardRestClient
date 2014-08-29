package com.wardziniak.jsonRestClient.clients;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

import com.wardziniak.jsonRestClient.exceptions.CannotCreateRestClient;
import com.wardziniak.jsonRestClient.exceptions.SSLRestClientException;

public abstract class SSLRestClient extends RestClient {


	protected SSLRestClient() throws CannotCreateRestClient {
		super();
	}

	@Override
	protected HttpClient createHttpClient() throws CannotCreateRestClient {
		try {
			return HttpClients.custom().setSslcontext(createSSLContext()).build();
		}
		catch (SSLRestClientException srce) {
			throw new CannotCreateRestClient();
		}
		
	}

	protected abstract SSLContext createSSLContext() throws SSLRestClientException;
	
	
}
