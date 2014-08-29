package com.wardziniak.jsonRestClient.clients;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.methods.HttpRequestBase;


import com.wardziniak.jsonRestClient.exceptions.CannotCreateRestClient;

public class BasicAuthenticationRestClient extends DefaultRestClient {
	
	public final String AUTHORIZATION_HEADER_LABEL = "Authorization";
	
	public final String AUTHORIZATIO_TYPE_BASIC = "Basic ";
	
	private final String authorizationHeader;

	protected BasicAuthenticationRestClient(String username, String password) throws CannotCreateRestClient {
		super();
		authorizationHeader = new String(Base64.encodeBase64((username+":"+password).getBytes()));
	}

	@Override
	protected void setHttpRequestParameters(HttpRequestBase httpRequestBase) {
		httpRequestBase.setHeader(AUTHORIZATION_HEADER_LABEL, AUTHORIZATIO_TYPE_BASIC + authorizationHeader);
	}

	
}
