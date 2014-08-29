package com.wardziniak.jsonRestClient.clients;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;

import com.wardziniak.jsonRestClient.exceptions.CannotCreateRestClient;
import com.wardziniak.jsonRestClient.exceptions.SSLRestClientException;

public class AcceptAllCertificationClient extends SSLRestClient {

	protected AcceptAllCertificationClient() throws CannotCreateRestClient {
		super();
	}

	@Override
	protected SSLContext createSSLContext() throws SSLRestClientException {
		try {
			SSLContext sslcontext = SSLContexts.custom()
			        .loadTrustMaterial(null, new TrustStrategy() {
			            public boolean isTrusted(
			                    final X509Certificate[] chain,
			                    final String authType) throws CertificateException {
			                return true;
			            }
			        }).build();
			return sslcontext;
		}
		catch (KeyManagementException e) {
			throw new SSLRestClientException();
		}
		catch (NoSuchAlgorithmException e) {
			throw new SSLRestClientException();
		}
		catch (KeyStoreException e) {
			throw new SSLRestClientException();
		}
	}


}
