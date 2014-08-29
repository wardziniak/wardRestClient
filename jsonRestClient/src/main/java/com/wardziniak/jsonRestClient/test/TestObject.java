package com.wardziniak.jsonRestClient.test;

import com.wardziniak.jsonRestClient.JSONableRequestObject;
import com.wardziniak.jsonRestClient.MethodType;

public class TestObject extends JSONableRequestObject {

	@Override
	public String getPathWithParameters() {
		// TODO Auto-generated method stub
		return "//legisPeritum/rest/pobierzMieszkania";
	}

	@Override
	public MethodType getMethodType() {
		// TODO Auto-generated method stub
		return MethodType.GET;
	}

}
