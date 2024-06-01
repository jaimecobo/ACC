package edu.acc.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Base64;

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
		Random rand = new SecureRandom();
		byte[] saltBytes = new byte[32];
		rand.nextBytes(saltBytes);
		System.out.println("Random salt				: " + Base64.getMimeEncoder().encodeToString(saltBytes));
		return Base64.getMimeEncoder().encodeToString(saltBytes);
	}
	
	public static String hashSaltAndPassword(String password, String salt) throws NoSuchAlgorithmException{
		System.out.println("Salted hash for received password	: " + hashPassword(password + salt));
		return
	}
}
