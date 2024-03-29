package com.lover.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class SendCode {
	// 发送验证码的请求路径URL
	private static final String SERVER_URL = "https://api.netease.im/sms/sendcode.action";
	// 网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
	private static final String APP_KEY = "368f8e218fb65863d3818f480bbc7f37";
	// 网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
	private static final String APP_SECRET = "a2fb91f56103";
	// 随机数
	private static final String NONCE = "123456";
	// 短信模板ID
	private static final String TEMPLATEID = "14793441";
	// 手机号
	private static String MOBILE =null;
	// 验证码长度，范围4～10，默认为4
	private static final String CODELEN = "6";

	public static void main(String[] args) throws Exception {

	}
	
	
	public static String getStringNum(String telNum) throws Exception{
		//发生给手机号验证码
		MOBILE = telNum;
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(SERVER_URL);
		String curTime = String.valueOf((new Date()).getTime() / 1000L);
		/*
		 * 参考计算CheckSum的java代码，在上述文档的参数列表中，有CheckSum的计算文档示例
		 */
		String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE,
				curTime);
		
		// 设置请求的header
		httpPost.addHeader("AppKey", APP_KEY);
		httpPost.addHeader("Nonce", NONCE);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=utf-8");
		
		// 设置请求的的参数，requestBody参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		/*
		 * 1.如果是模板短信，请注意参数mobile是有s的，详细参数配置请参考“发送模板短信文档” 2.参数格式是jsonArray的格式，例如
		 * "['13888888888','13666666666']"
		 * 3.params是根据你模板里面有几个参数，那里面的参数也是jsonArray格式
		 */
		nvps.add(new BasicNameValuePair("templateid", TEMPLATEID));
		nvps.add(new BasicNameValuePair("mobile", MOBILE));
		nvps.add(new BasicNameValuePair("codeLen", CODELEN));
		
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		
		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		/*
		 * 1.打印执行结果，打印结果一般会200、315、403、404、413、414、500
		 * 2.具体的code有问题的可以参考官网的Code状态表
		 */
		String str = EntityUtils.toString(response.getEntity(), "utf-8");
		String[] strs = str.split(":");
		String result = strs[3];
		if(result!=null){
			String yzm = result.substring(1, 7);
			return yzm;
		}
		return "0";
	}
	
}
