package com.auto.http;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;

/**
 * @author fengyiwen
 *
 */

public class CommonUtils {
	public static boolean base64ToImg(String base64Str,String fileNameWithPath){
		ByteArrayInputStream in = null;
		FileOutputStream out = null;
		try {
			byte[] bytes = Base64.decodeBase64(base64Str);
			in = new ByteArrayInputStream(bytes);
			out = new FileOutputStream(fileNameWithPath);
			int byteRead = 0;
			byte[] buffer = new byte[1024];
			while((byteRead = in.read(buffer)) != -1){
				out.write(buffer,0,byteRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		File file = new File(fileNameWithPath);
		return file.exists();
	}

	public static String imgToBase64(String fileName) throws FileNotFoundException{
		String base64Str = null;
		InputStream in = null;
		try {
			in = new FileInputStream(fileName);
			byte[] bytes = new byte[in.available()];
			in.read(bytes);
			//base64Str = new BASE64Encoder().encode(bytes);
			base64Str = Base64.encodeBase64String(bytes);
		}catch(FileNotFoundException e){
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return base64Str;
	}
}
