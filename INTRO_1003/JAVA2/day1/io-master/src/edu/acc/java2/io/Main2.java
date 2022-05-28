package edu.acc.java2.io;

import java.io.*;

public class Main2 {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java edu.acc.java2.io.Main2 <filename>");
			return;
		}
		try (DataInputStream dis = new DataInputStream(
			 new BufferedInputStream(new FileInputStream(args[0])))) {
			for (int i = 0; i < 100; i++) {
				System.out.println(dis.readByte());
			}
			System.out.println(dis.readInt());
			System.out.println(dis.readDouble());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}









