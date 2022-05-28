/*
	Write a Java program that prompts the user for lines
	of input and writes those lines to a file until the
	line ends with the text :end:
	Goodbye!:end:
*/
package edu.acc.java2.io;

import java.io.*;

public class Main3 {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java edu.acc.java2.io.Main3 <filename>");
			return;
		}
		try (PrintWriter out = new PrintWriter(new BufferedWriter(
				new FileWriter(args[0])))) {
			boolean done = false;
			do {
				String line = System.console().readLine();
				if (line.endsWith(":end:")) {
					done = true;
					line = line.substring(0, line.length() - 5);
					if (line.length() != 0)
						line += "\n";
				}
				else line += "\n";
				out.print(line);
			} while (!done);
		}
		catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
		}
		catch (IOException ioe) {
			System.out.println("Something bad happened: " + ioe.getMessage());
		}	
	}
}









