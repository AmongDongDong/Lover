package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101100658402";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = 
    		"MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCergfbiK2mcv3s" + 
    		"vj3yg7tUxCgQndSm6JEJlcITYUz+AXu9TBkBD9af7ap8kr5eVCyhSt5TWde0GRFU" + 
    		"APnEpGYGdbIJxZnWWGHgV+9WVyJK47ef3THeDqMRJq7gYF4tspdQABOea8wEAaJ8" + 
    		"YJlim071ADiS2vAKCQG+PVF5O0XEsQw0hzpD2Fngwk6DgNc0z6TT+F7C2je7rQ8l" + 
    		"/hlvEgx8Q0lU0TYJ1RPI+ixDA5+SLOq9TD+H+0/yY43sEcFoT96iv9JmOUqrk4rB" + 
    		"HD6ZsfWN01AfPYJs0K+XCzSPp/uv4FItnVyUJghHaAb6PGLBLYLAvqhCBpmukNzL" + 
    		"JDFNdB/5AgMBAAECggEBAIiUMK00GotPJOKV6MoJur8+S2HqB7RWLyh5319A+70R" + 
    		"18jabBcu48QqE/k/cV3Nw9BcmbpSdUhN301XvaQVAMAEo+anTz9gOXaZGadOPnUJ" + 
    		"Re7yu85u+Mp1akY0jDt3Iag5OKm+DQ9RvOKjXsKx/ScCNq+ohL2OfRKawrq/WtDt" + 
    		"W9rSoT0u4QIVcwRLIp2k47FY8uGkheZjWrE9Rtv0SBbRY7nHe8r9mLHB9SA0tAJF" + 
    		"gNuqLBll5iObFJMpcUFncE7Rw33zWH7myhc83YU3iSTRYAKpEbjHtI4CR3FbqJib" + 
    		"Vvweq7NJ7MDbof+ZYwXABnee7Aaqf82Vh7Ky88pnUFUCgYEA0hZ2C1/HP/GbSmZs" + 
    		"HttoT5/Pl/gwgN3T00TciR3B76sfp/EeHLq7qTRnMI5cMOR83EaABMVFTMmMZ1Jp" + 
    		"sst4fdlfhQvQiNQZ1Kw1vJW+Ni6g/eqzViWB2IrbX7ZTSLLqLJmwk1YqSRnM7EV3" + 
    		"aB6GNi48wCO3SuNxbHRB+AqwzXcCgYEAwVuCPG3vTJ9YOWYUGnMjUOjSJOrg3ZjB" + 
    		"sF2I322Mq9TXGnqpkN0EyWbSHaWRznMxBAjI/YJj0SsFuMlKS1S/XzJyOPD2g1I5" + 
    		"wf/BuxDZhOh5BO6F0tRljqGraCZPCka49qiyvy97EXCnGFmGiLN+r14m7MD8mG+P" + 
    		"unB+q3AWGg8CgYALMoFGJ+uxv8ncFEts9ZrAq67f1a2YILqahxAOCtT8Vi2QwOwu" + 
    		"8dDwusdJMj09qd/xyZwnJPCFoDRoiV7y1Z9tbbmGmNObh1p9GFSg4YZK0v9nqSu3" + 
    		"yrX5+aSpnEkiFc8fY22i3LPSQ5rFeQpdNUtH9fzs7LpnNmokMqoVc1RrDwKBgAY1" + 
    		"IeE+xkf3daWiGVMgDyoxz01QHRgAJ3e6CQLjSXjaxG0dMwRrlBPDMUuyXRP7rr8q" + 
    		"aQl6fing77YXAEOa3On5fKFHWyKsKR6JT3bp+5HAxOHbpoA2QWxq1E3rrO3vh1Cj" + 
    		"6dkpdRICQ9sMRL1uxcprg2RmbbWXH04k/mwSlSMRAoGBALk6aV6llvbVZK0nTpaB" + 
    		"dWUSxFXgX2YkNs2U3U6fsr2yY1a2zZHuclNkQgAxFp9QFzLhq1tdUQrvThO8bi0L" + 
    		"88LzTJSVw4VRqetJgqrykkmpDsMXw3TXOUskmGyLi0+f7DotW8BvgCj+ywCkLFGw" + 
    		"GrGeAhXSM6kFQHRJh3HAxBwR";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzfsXHqCbfe4A/W62EqRxZszZgt/aCImFzDPdM/bRPnf2gRIDL/66SuBxstweP6KIldZiy1b/J7hT6uyaelzBSTslUgYAzAi29DF9C5PidK8AOjXrnYtDOA4Y6iiATyxDF+xOxV5Sh0NGROWOhIXXYUy4q+Zeahjv9VEGL9l+UGigzIiB8GXMmNiZVgDw1nWyVWlDYt7H0xPd2hx90TBIDtTuPYPLE1JeeX2WDblFo+Yt4/6j/ciGu1Xqt/MOiqFFhlU4Ce7nZFssvZzv4PNny6cHz0luKb23Kmj4lRngbJAhBntoPuPZHa9ORSISNpnrJVr4ArAtxbNk9bGz22xVzQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8088/LoverOS/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

