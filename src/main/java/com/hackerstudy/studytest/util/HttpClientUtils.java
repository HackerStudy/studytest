package com.hackerstudy.studytest.util;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

/**
 * 
 * 
 * @author dengfl
 * 
 */
@SuppressWarnings("deprecation")
public class HttpClientUtils {
	private static final Logger logger = LoggerFactory
			.getLogger(HttpClientUtils.class);
	
	/**
	 * 用户名
	 */
	private static final String USERNAME_PARAM = "username";
	
	/**
	 * 参数
	 */
	private static final String PASSWORD_PARAM = "password";
	
	/**
	 * 默认HTTP头信息
	 */
	private static Map<String, String> defaultHeaders = new HashMap<String, String>();
	
	/**
	 * 初始化默认HTTP头信息
	 */
	static {
		defaultHeaders.put("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.1.2)");
		defaultHeaders.put("Content-Type", "application/x-www-form-urlencoded");
	}
	
	/**
	 * 登录后提交
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @param postUrl
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String loginAndPost(String url, String username, String password, String postUrl, Map<String, Object> params) throws Exception{
		DefaultHttpClient httpClient = new DefaultHttpClient();
		Map<String, Object> loginParams = new HashMap<String, Object>();
		loginParams.put(USERNAME_PARAM, username);
		loginParams.put(PASSWORD_PARAM, password);
		post(url, loginParams, httpClient);
		CookieStore cookieStore = httpClient.getCookieStore();
		httpClient = new DefaultHttpClient();
		httpClient.setCookieStore(cookieStore);
		return post(postUrl, params, httpClient);
	}

	public static String post(String url) throws Exception {
		return post(url, null, null);
	}
	
	public static String post(String url, DefaultHttpClient httpClient) throws Exception {
		return post(url, null, httpClient);
	}
	
	public static String post(String url, Map<String, Object> params) throws Exception {
		return post(url, params, null);
	}
	
	public static String post(String url, Map<String, Object> params, DefaultHttpClient httpClient) throws Exception {
		return post(url, defaultHeaders, params, httpClient, null);
	}
	
	/**** 自定义超时时间 *****/
	public static String postForChaoShi(String url, Integer time) throws Exception {
		return postForChaoShi(url, null, null, time);
	}
	
	public static String postForChaoShi(String url, DefaultHttpClient httpClient, Integer time) throws Exception {
		return postForChaoShi(url, null, httpClient, time);
	}
	
	public static String postForChaoShi(String url, Map<String, Object> params, Integer time) throws Exception {
		return postForChaoShi(url, params, null, time);
	}
	
	public static String postForChaoShi(String url, Map<String, Object> params, DefaultHttpClient httpClient, Integer time) throws Exception {
		return post(url, defaultHeaders, params, httpClient, time);
	}


	/********/

	public static String post(String url, Map<String, String> headers, Map<String, Object> params,
			 DefaultHttpClient httpClient, Integer time) throws Exception {
		logger.info("httpPost URL [" + url + "] start ");
		if(httpClient == null){
			httpClient = new DefaultHttpClient();
		}
		HttpPost httpPost = new HttpPost(url);
		try {
			if (headers != null) {
				setHeaders(httpPost, headers);
			} else {
				setHeaders(httpPost, defaultHeaders);
			}
			List<NameValuePair> nvps = setParams(params);
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			setTimeouts(httpClient, httpPost, time);
			return readResponseBody(httpClient, httpPost);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}

	private static void setHeaders(HttpPost httpPost,
			Map<String, String> headers) {
		for (Entry<String, String> entry : headers.entrySet()) {
			httpPost.setHeader(entry.getKey(), entry.getValue());
		}
	}

	private static List<NameValuePair> setParams(Map<String, Object> params) {
		StringBuilder paramsLogBuilder = new StringBuilder();
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if (params == null) {
			return nvps;
		}
		for (Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value == null) {
				nvps.add(new BasicNameValuePair(key, ""));
				paramsLogBuilder.append("[" + key + "-]");
				continue;
			}
			if (String[].class.isInstance(value)) {
				String[] strArray = (String[]) value;
				for (String str : strArray) {
					nvps.add(new BasicNameValuePair(key, str));
				}
				paramsLogBuilder.append("[" + key + "- "
						+ Arrays.asList(strArray) + "]");
				continue;
			}
			nvps.add(new BasicNameValuePair(key, value.toString()));
		}
		logger.info("params:" + paramsLogBuilder.toString());
		return nvps;
	}

	private static void setTimeouts(DefaultHttpClient httpclient,
			HttpPost httpPost, Integer time) {
		if(time == null || time <= 0){
			time = 10000;
		}
		HttpConnectionParams.setConnectionTimeout(httpclient.getParams(), time);
		HttpConnectionParams.setSoTimeout(httpPost.getParams(), time);
	}

	private static String readResponseBody(DefaultHttpClient httpclient,
			HttpPost httpPost) throws Exception {
		HttpResponse response = httpclient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			byte[] bytes = EntityUtils.toByteArray(entity);
			return new String(bytes, "UTF-8");
		}
		return "";
	}
	public static String post(String url, com.alibaba.fastjson.JSONObject params) throws Exception {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);

		StringEntity entity = new StringEntity(params.toJSONString(), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httppost.setEntity(entity);

		HttpResponse response;
		String strResult = null;
		try {
			response = httpclient.execute(httppost);
			if (response.getStatusLine().getStatusCode() == 200) {
				strResult = EntityUtils.toString(response.getEntity());
			} else {
				String err = response.getStatusLine().getStatusCode() + "";
				strResult += "发送失败:" + err;
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return strResult;
	}

	/**
	 * @description: post请求，json
	 * @param: [url, headers, json]
	 * @return: java.lang.String
	 * @auther: Hacker
	 * @date: 2020-12-10 17:54
	 * @throws
	 */
	public static String postJSON(String url, Map<String, String> headers,String json){
		logger.error("POST:url="+url+",headers="+JSON.toJSONString(headers)+",json="+json);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String result = null;
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
		if(null!=headers){
			setHeaders(httpPost, headers);
		}
		try {
			StringEntity entity = new StringEntity(json, "UTF-8");
			httpPost.setEntity(entity);
			response = httpClient.execute(httpPost);
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				try {
					result = EntityUtils.toString(response.getEntity(),"UTF-8");
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}else {
				logger.error("接口返回状态码："+response.getStatusLine().getStatusCode()+"，返回信息："+EntityUtils.toString(response.getEntity(),"UTF-8"));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}finally {
			if(response != null){
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return result;
		}
	}

	public static void main(String[] args) {
		try{
			com.alibaba.fastjson.JSONObject params=new com.alibaba.fastjson.JSONObject();
			params.put("guid","66d6820c-5871-4d59-998e-9b47caa6eded");
			post("http://112.zhulong.com.cn:10080/km/jdptwebapi/Token/getLoginInfo?guid=66d6820c-5871-4d59-998e-9b47caa6eded",params);
		}catch (Exception e){
			e.printStackTrace();
		}

	}
}
