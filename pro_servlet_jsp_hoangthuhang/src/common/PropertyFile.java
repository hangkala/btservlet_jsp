/**
 * Copyright(C) 2019 Luvina JSC
 * PropertyFile.java, Oct 2, 2019, HangHT
 */
package common;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
		String configPath = rootPath + "resources/config.properties";
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
	
	public String getProp(String propName) {
		Properties properties = new Properties();
		InputStream in = getClass().getClassLoader().getResourceAsStream("resources/config.properties");
		try {
			properties.load(in);
			System.out.println(properties.get("url"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (String) properties.get(propName);
	}
	
	public static void getProp2(String propName) {
		URL resourceURL = PropertyFile.class.getResource("/resources/config.properties");
		System.out.println(resourceURL);
        Properties appConfig = new Properties();
        try {
            appConfig.load(resourceURL.openStream());
            System.out.println(appConfig.getProperty("user"));
            System.out.println(appConfig.getProperty("pass"));

        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	public static void main(String[] args) {
		PropertyFile p = new PropertyFile();
		//System.out.println(p.readProperty("pass"));
		p.getProp("pass");
		//getProp2(null);
	}
	
}
