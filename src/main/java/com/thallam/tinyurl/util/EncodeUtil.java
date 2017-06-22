package com.thallam.tinyurl.util;

import org.springframework.stereotype.Component;

@Component
public class EncodeUtil {

	public final String ALPHABET = "123456789bcdfghjkmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ-_";
	public final int BASE = ALPHABET.length();
	public final int hashlength = 6;
	

	public String encode(int num) {
		StringBuilder str = new StringBuilder();
		while (num > 0) {
			str.insert(0, ALPHABET.charAt(num % BASE));
			num = num / BASE;
		}
		System.out.println("Str length is "+str.length());
		return str.toString();
	}

	public int decode(String str) {
		int num = 0;
		for (int i = 0; i < str.length(); i++) {
			num = num * BASE + ALPHABET.indexOf(str.charAt(i))==-1?0:ALPHABET.indexOf(str.charAt(i));
		}
		return num;
	}

}