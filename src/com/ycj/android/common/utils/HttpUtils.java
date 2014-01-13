package com.ycj.android.common.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * @ClassName: HttpUtils
 * @Description: TODO(网络连接工具类)
 * @author yangchj
 * @date 2013-9-15 下午9:20:09
 */
public class HttpUtils {
	
	private static int TIME_OUT_SOCKET_DELAY=5*1000;//响应时间
	private static int TIME_OUT_CONN_DELAY=5*1000;//连接时间
	
	/**
	 * @Title: sendPostRequest
	 * @Description: TODO(发送Post请求)
	 * @return String    返回类型
	 * @throws
	 */
	public static String sendPostRequest(String url,Map<String,String> params){
		String result="";
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();// 存放请求参数
		if(params!=null && !params.isEmpty()){
			for(Map.Entry<String, String> entry:params.entrySet()){
				pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}
		HttpPost httpPost = new HttpPost(url); 
		HttpClient httpClient=initHttp();
		HttpResponse httpResponse = null; 
		try{
			//设置httpPost请求参数 
            httpPost.setEntity(new UrlEncodedFormEntity(pairs, HTTP.UTF_8)); 
            httpResponse =httpClient.execute(httpPost); 
            int code=httpResponse.getStatusLine().getStatusCode();
            if (code == 200) { 
            	result = EntityUtils.toString(httpResponse.getEntity()); 
            }
            //result = EntityUtils.toString(httpResponse.getEntity()); 
            
		}catch(ConnectTimeoutException e){//超时异常
			e.printStackTrace();
		}catch(ClientProtocolException e){//不符合http协议
			 e.printStackTrace(); 
		}catch(IOException e){//响应异常 
			 e.printStackTrace(); 
		}finally{
			httpClient.getConnectionManager().shutdown();
		}
		return result;
	}
	
	public static HttpClient initHttp(){
		HttpClient client = new DefaultHttpClient();
		client.getParams().setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, TIME_OUT_CONN_DELAY);//连接超时
		client.getParams().setIntParameter(HttpConnectionParams.SO_TIMEOUT, TIME_OUT_SOCKET_DELAY);//响应超时
		return client;
	}
	
	/**
	 * 向指定URL发送GET方法的请求
	 */
	public static String sendGet(String url, String params) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlName = url + "?" + params;
			URL realUrl = new URL(urlName);
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// 建立实际的连接
			conn.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = conn.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
//			int code=conn.getResponseCode();
//			if(code==201){
//				result=conn.getHeaderField("jsessionid");
//			}
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += "\n" + line;
			}
			LogUtils.i(result);
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 向指定URL发送GET方法的请求
	 */
	public static Map<String,Object> sendLoginGet(String url, String params) {
		String result = "fail";
		String jsessionid="";
		String fail_info="";
		Map<String,Object> map=new HashMap<String, Object>();
		BufferedReader in = null;
		try {
			String urlName = url + "?" + params;
			URL realUrl = new URL(urlName);
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// 建立实际的连接
			conn.connect();
			// 获取所有响应头字段
//			Map<String, List<String>> map = conn.getHeaderFields();
			// 遍历所有的响应头字段
//			for (String key : map.keySet()) {
//				System.out.println(key + "--->" + map.get(key));
//			}
			int code=conn.getResponseCode();
			if(code==201){
				result="success";
				jsessionid=conn.getHeaderField("jsessionid");
				fail_info="登陆成功";
			}else if(code==401){
				fail_info="用户名或密码错误";
			}
			// 定义BufferedReader输入流来读取URL的响应
//			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			String line;
//			while ((line = in.readLine()) != null) {
//				result += "\n" + line;
//			}
			LogUtils.i(result);
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			fail_info="请求异常!";
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		map.put("result", result);
		map.put("fail_info", fail_info);
		map.put("jsessionid", jsessionid);
		return map;
	}
	/**
	 * 向指定URL发送POST方法的请求  
	 */
	public static String sendPost(String url, String params) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(params);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += "\n" + line;
			}
		} catch (Exception e) {
			System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

}
