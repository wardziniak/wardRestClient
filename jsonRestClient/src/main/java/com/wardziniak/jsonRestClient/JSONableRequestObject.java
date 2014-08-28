package com.wardziniak.jsonRestClient;

import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.StringEntity;

public abstract class JSONableRequestObject {

	public String toJSON() {
		return null;
	}
	
	public abstract String getPathWithParameters();
	
	public boolean hasJsonableContent() {
		return false;
	}
	
	public final HttpEntityEnclosingRequestBase addToBody(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase) throws UnsupportedEncodingException {
		if (hasJsonableContent())
		{
			StringEntity entity = new StringEntity(toJSON());
			entity.setContentType(Request.APPLICATION_JSON);
			httpEntityEnclosingRequestBase.setEntity(entity);
		}
		return httpEntityEnclosingRequestBase;
	}
	
	
	/**
	 * @return - methodType that request object needs
	 */
	public abstract MethodType getMethodType();
	
}
