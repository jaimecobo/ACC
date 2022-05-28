package edu.acc.java2.io;

import java.io.*;

public class Main1 {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java edu.acc.java2.io.Main1 <filename>");
			return;
		}
		try (FileOutputStream fos = new FileOutputStream(args[0]);
		     BufferedOutputStream bos = new BufferedOutputStream(fos);
			 DataOutputStream dos = new DataOutputStream(bos)) {
			for (int i = 0; i < 100; i++) {
				dos.writeByte(i);
			}
			dos.writeInt(Integer.MAX_VALUE);
			dos.writeDouble(Math.PI);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}









