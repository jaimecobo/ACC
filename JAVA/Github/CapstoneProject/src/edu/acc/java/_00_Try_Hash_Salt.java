package edu.acc.java;

import javax.swing.JPanel;

public class _00_Try_Hash_Salt {

	static String password = "administrator";
	static final JPanel panel = new JPanel();
	public static void main (String[] args) {
	try {
	_00_Hashing_Salting_Passwords.checkPasswordStrength(
	}catch(Exception ex) {
		System.out.println("Exception at _00_Try_Hash_Salt checkPasswordStrength = " + ex);
	}
		
	}
}