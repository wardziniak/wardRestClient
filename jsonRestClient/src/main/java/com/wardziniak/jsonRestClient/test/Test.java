package com.wardziniak.jsonRestClient.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.wardziniak.jsonRestClient.Request;
import com.wardziniak.jsonRestClient.Response;
import com.wardziniak.jsonRestClient.RestClient;
import com.wardziniak.jsonRestClient.RestClientFactory;
import com.wardziniak.jsonRestClient.test.model.Blok;

public class Test {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		RestClient restClient = RestClientFactory.getRestClient(null);
		Request request = new Request("", "", new TestObject());
		Response<Blok> response = restClient.execute(request, Blok.class);
		response.getResourcse();
		System.out.println(":" + response.getResourcse().getLiczbaMieszkan());
	}
	
}
