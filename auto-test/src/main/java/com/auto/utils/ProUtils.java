package com.auto.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * 配置文件读取
 * @author john
 *
 */
public class ProUtils {
	private static  final Logger logger = LogManager.getLogger(TestUtils.class);
	private static ResourceBundle bundle;
	static{
		bundle  = ResourceBundle.getBundle("dataSource");
	}

	/**
	 * 根据key获取配置文件的值
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String getConfig(String key)  {
		logger.info("key:{}",key);
		return bundle.getString(key);
	}
}
