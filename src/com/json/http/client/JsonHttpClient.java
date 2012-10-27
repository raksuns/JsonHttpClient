package com.json.http.client;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.zip.GZIPInputStream;

import net.sf.json.JSONObject;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.ErrorCode;

public class JsonHttpClient
{

	private static Logger		log	= Logger.getLogger(JsonHttpClient.class);

	private static final String	TAG	= "HttpClient";

	public static String sendHttpGet(String URL) {
		DefaultHttpClient client = new DefaultHttpClient();
		String responseBody = "";
		HttpGet httppost = new HttpGet(URL);

		try {
			log.debug("----------------------------------------");
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			responseBody = client.execute(httppost, responseHandler);
			log.debug(responseBody);

			log.debug("----------------------------------------");

		}
		catch(ClientProtocolException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			client.getConnectionManager().shutdown();
		}
		return responseBody;
	}

	public static String sendHttpPost(String URL, JSONObject jsonObjSend) {
		InputStream instream = null;
		try {
			DefaultHttpClient httpclient = new DefaultHttpClient();

			HttpParams params = httpclient.getParams();
			HttpConnectionParams.setConnectionTimeout(params, 10000);
			HttpConnectionParams.setSoTimeout(params, 10000);
			httpclient.setParams(params);

			HttpPost httpPostRequest = new HttpPost(URL);
			StringEntity se = new StringEntity(jsonObjSend.toString(), "UTF-8");

			httpPostRequest.setEntity(se);
			httpPostRequest.setHeader("Accept", "application/json");
			httpPostRequest.setHeader("Content-type", "application/json");
			httpPostRequest.setHeader("Accept-Encoding", "gzip"); // only set

			long t = System.currentTimeMillis();
			HttpResponse response = (HttpResponse)httpclient.execute(httpPostRequest);
			log.debug("HTTPResponse received in [" + (System.currentTimeMillis() - t) + "ms]");
			// Get hold of the response entity (-> the data):

			HttpEntity entity = response.getEntity();

			if(entity != null) {

				instream = entity.getContent();
				Header contentEncoding = response.getFirstHeader("Content-Encoding");

				if(contentEncoding != null && contentEncoding.getValue().equalsIgnoreCase("gzip")) {
					instream = new GZIPInputStream(instream);
				}

				String resultString = convertStreamToString(instream);

				return resultString;
			}
		}
		catch(SocketTimeoutException ste) {
			ste.printStackTrace();
			return null;
		}
		catch(SocketException se) {
			se.printStackTrace();
			return null;
		}
		catch(IOException ie) {
			ie.printStackTrace();
			return null;
		}
		catch(Exception e) {
			log.error("", e);

		}
		finally {
			try {
				if(instream != null) {
					instream.close();
				}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private static String convertStreamToString(InputStream is) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;

		try {
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}

		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(is != null) {
					is.close();
				}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}

		return sb.toString();

	}
}
