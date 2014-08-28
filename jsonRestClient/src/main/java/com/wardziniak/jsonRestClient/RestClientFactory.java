package com.wardziniak.jsonRestClient;

public class RestClientFactory {

	public static RestClient getRestClient(RestClientType restClientType) {
		return new DefaultRestClient("http://localhost:8080/");
	}
}
