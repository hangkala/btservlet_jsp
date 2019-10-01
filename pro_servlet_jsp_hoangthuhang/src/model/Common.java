/**
 * Copyright(C) 2019 Luvina JSC
 * Common.java, Sep 27, 2019, HangHT
 */
package model;

import java.util.Base64;
import java.util.Random;

/**
 * @author HangHT
 *
 */
public class Common {
	public String encript(String pass) {
		byte[] encodePass = (pass + getSalt()).getBytes();
		String hash = Base64.getEncoder().encodeToString(encodePass);
		return hash;
	}
	
	public static String encodeHTML(String str) {
		String[] lsSpecialChar = {"\"","&","'","/","<",">"};
		for (int i = 0; i < lsSpecialChar.length; i++) {
			if(str.indexOf(lsSpecialChar[i]) > -1) {
				str=str.replaceAll(lsSpecialChar[i], convertChar(lsSpecialChar[i]));
			}
		}
		return str;
	}

	private static String convertChar(String specialChar) {
		String kq = "";
		switch (specialChar) {
		case "\"":
			kq = "&quot;";
			break;
		case "&":
			kq = "&amp;";
			break;
		case "'":
			kq = "&#x27;";
			break;
		case "<":
			kq = "&lt;";
			break;
		case ">":
			kq = "&gt;";
			break;
		default:
			break;
		}
		return kq;
	}
	
	public String getSalt() {
		StringBuilder salt = new StringBuilder();
		int length = (new Random()).nextInt(255);
		for (int i = 0; i < length; i++) {
			int randomNumber = (int)(Math.random()*122) + 48;
			char ch = (char) randomNumber;
			salt.append(ch);
		}
		return salt.toString();
	}

}
