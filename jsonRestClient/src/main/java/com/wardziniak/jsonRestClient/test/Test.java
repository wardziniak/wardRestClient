package com.wardziniak.jsonRestClient.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.wardziniak.jsonRestClient.Request;
import com.wardziniak.jsonRestClient.Response;
import com.wardziniak.jsonRestClient.clients.RestClient;
import com.wardziniak.jsonRestClient.clients.RestClientFactory;
import com.wardziniak.jsonRestClient.clients.RestClientType;
import com.wardziniak.jsonRestClient.exceptions.CannotCreateRestClient;
import com.wardziniak.jsonRestClient.exceptions.IncorrectRestClientInitializationMethod;
import com.wardziniak.jsonRestClient.exceptions.UnknownRestClient;
import com.wardziniak.jsonRestClient.test.model.Blok;

public class Test {

	public static void main(String[] args) throws ClientProtocolException, IOException, UnknownRestClient, CannotCreateRestClient, IncorrectRestClientInitializationMethod {
		//RestClient restClient = RestClientFactory.getRestClient(null);
		//RestClient restClient = RestClientFactory.getRestClient(RestClientType.AcceptAllCertificationClient, "https://localhost:8080");
		RestClient restClient = RestClientFactory.getRestClient(RestClientType.BASIC, "http://localhost:8080/");
		Request request = new Request(new TestObject());
		Response<Blok> response = restClient.execute(request, Blok.class);
		response.getResourcse();
		System.out.println(":" + response.getResourcse().getLiczbaMieszkan());
	}
	
}
