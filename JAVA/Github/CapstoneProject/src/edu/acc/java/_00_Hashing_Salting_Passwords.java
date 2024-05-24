package edu.acc.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util

public class _00_Hashing_Salting_Passwords {

	public static String hashPassword(String password) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.reset();
		md.update(password.getBytes());
		byte[] mdArray = md.digest();
		StringBuilder sb = new StringBuilder(mdArray.length * 2);
		for (byte b : mdArray) {
			int v = b & 0xff;
			if(v<16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString();
	}
	
	public static String getSalt() {
		Random
	}	
}
