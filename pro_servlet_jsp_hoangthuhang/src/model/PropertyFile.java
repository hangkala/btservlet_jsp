/**
 * Copyright(C) 2019 Luvina JSC
 * PropertyFile.java, Oct 2, 2019, HangHT
 */
package model;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @author HangHT
 *
 */
public class PropertyFile {
	public static String readProperty(String propName) {
		Properties properties = new Properties();
		FileInputStream in = null;
		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String configPath = rootPath + "config.properties";
		System.out.println(configPath);
		try {
			in = new FileInputStream(configPath);
			properties.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return (String) properties.get(propName);
	}
	
}
