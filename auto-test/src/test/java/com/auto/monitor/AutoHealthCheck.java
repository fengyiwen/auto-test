package com.auto.monitor;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.codec.Charsets;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.auto.http.HttpResponse;
import com.auto.utils.ProUtils;
import com.auto.v30.CarListTest;

/**
 * @author fengyiwen
 *
 */

public class AutoHealthCheck {
	
	public static String resourceFile="healthCheck.properties";
	public  long waitTime = Long.parseLong(getConfig("waitTime"));
	public  String path=getConfig("logFilePath");
	protected CarListTest carListCheck = new CarListTest();
	
	public  void apiHealthCheck() throws Exception{
		
		
		String date = getCurrentTime("yyyyMMdd");
		String lastDate = getCurrentTime("yyyyMMdd");
		int i =0;
		int errorCount = 0;
		FileWriter fw;
		while (true){
			date =  getCurrentTime("yyyyMMdd");
			if (date.equals(lastDate)){
				 fw = new FileWriter(path+"healthcheck_"+lastDate+".txt",true);  //same file 
			}else{
				 fw = new FileWriter(path+"healthcheck_"+date+".txt",true); // new file
				 i = 0;
			}
			String status = "No:"+i+" "+getCurrentTime("yyyy-MM-dd HH:mm:ss")+" Access "+carListCheck.getApiDestion();
			try {
				carListCheck.getCarList();
				status=status+" Success";
				sendWarningMessage();
			}catch (Throwable e){
				if (errorCount>2){
					System.exit(0);
				}
				status=status+" Error";
				sendWarningMessage();
				errorCount++;
			}
			System.out.println(status);
			fw.write(status+"\r\n");
			fw.close();
			i++;
			Thread.sleep(waitTime);
			lastDate = date;
			
		}
	}
	
	
	
	public static String getCurrentTime(String format){
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(System.currentTimeMillis());
		
	}
	
	
	public static void sendWarningMessage(){
		System.out.println("smscontent="+sendSmsContent());
		HttpPost post = new HttpPost("https://api.miaodiyun.com/20150822/industrySMS/sendSMS"+sendSmsContent());
		CloseableHttpClient httpClient = HttpClients.createDefault();
    	HttpResponse actualHttpResponse = new HttpResponse();
    	try {
        	org.apache.http.HttpResponse response = httpClient.execute(post);
            int code = response.getStatusLine().getStatusCode();
            actualHttpResponse.setHttpRespCode(code);
            if (code == 200) {
                /**/
            }
            System.out.println("response="+response.getEntity().getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	if(httpClient != null)
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	
        }
    	
	}
	
	public static String sendSmsContent(){
		String currentTime = getCurrentTime("yyyyMMddHHmmss");
		String phoneNumbers= getConfig("sendToPhoneNumber");
		String content = getConfig("smsContent");
		String sig=string2MD5("9c819aef67de4f0f9837b7eb27e747c50a82c206c231443bbd9e9627012fc6da"+currentTime);
		String sendSmsContent = "?accountSid=9c819aef67de4f0f9837b7eb27e747c5"
				+ "&smsContent="+content
				+ "&to="+phoneNumbers
				+ "&timestamp="+currentTime
				+ "&sig="+sig
				+ "&respDataType=JSON";
		return sendSmsContent;
	}
	
	public static String getConfig(String key){
		String filename = resourceFile;  
        Properties props = new Properties();  
        try {
        	props.load(new InputStreamReader(AutoHealthCheck.class.getClassLoader().getResourceAsStream(filename), "UTF-8"));  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        return props.getProperty(key);
	}
	
	public static String string2MD5(String inStr){  
        MessageDigest md5 = null;  
        try{  
            md5 = MessageDigest.getInstance("MD5");  
        }catch (Exception e){  
            System.out.println(e.toString());  
            e.printStackTrace();  
            return "";  
        }  
        char[] charArray = inStr.toCharArray();  
        byte[] byteArray = new byte[charArray.length];  
  
        for (int i = 0; i < charArray.length; i++)  
            byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)  
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
        }  
        return hexValue.toString();  
  
    }   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutoHealthCheck  check = new AutoHealthCheck();
		try{
			check.apiHealthCheck();
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	
	
}
