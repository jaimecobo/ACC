package edu.acc.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class _00_Hashing_Salting_Passwords {

	public static String hashPassword(String password) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.reset();
		md.update(password.getBytes());
		byte[] mdArray = md.digest();
		StringBuilder sb = new
	}
}
