package com.wardziniak.jsonRestClient.clients;

import com.wardziniak.jsonRestClient.exceptions.CannotCreateRestClient;
import com.wardziniak.jsonRestClient.exceptions.IncorrectRestClientInitializationMethod;
import com.wardziniak.jsonRestClient.exceptions.UnknownRestClient;



public class RestClientFactory {
	
	public static RestClient getBasicAuthenticationRestClient(String hostname, String username, String password) throws CannotCreateRestClient {
		RestClient restClient;
		restClient = new BasicAuthenticationRestClient(username, password);
		restClient.setHostname(hostname);
		return restClient;
	}

	public static RestClient getRestClient(RestClientType restClientType, String hostname) throws UnknownRestClient, CannotCreateRestClient, IncorrectRestClientInitializationMethod {
		RestClient restClient;
		switch (restClientType) {
			case BASIC:
				restClient = new DefaultRestClient();
				break;
			case AcceptAllCertificationClient:
				restClient = new AcceptAllCertificationClient();
				break;
			case BasicAuthenticationRestClient: 
				throw new IncorrectRestClientInitializationMethod();
			default:
				throw new UnknownRestClient();
			
		}
		restClient.setHostname(hostname);
		return restClient;
	}
}
