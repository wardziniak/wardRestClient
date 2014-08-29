package com.wardziniak.jsonRestClient.clients;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.wardziniak.jsonRestClient.exceptions.CannotCreateRestClient;

public class DefaultRestClient extends RestClient {
	
	//private HttpClient httpClient;// = HttpClients.createDefault();
	
	//private final String host;
	
	//private static WardRestClient wardClient = null;
	
	protected DefaultRestClient() throws CannotCreateRestClient {
		super();
		// TODO Auto-generated constructor stub
	}

	public static final int TIMEOUT = 3000;
	
//	protected DefaultRestClient(String host) throws CannotCreateRestClient {

	    //httpClient = new DefaultHttpClient();
/*		this.setHostname(host);
		try {
			confSSL();
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
//	}

	@Override
	protected HttpClient createHttpClient() {
		//return new DefaultHttpClient();
		return HttpClients.custom().build();
	}
	
}
