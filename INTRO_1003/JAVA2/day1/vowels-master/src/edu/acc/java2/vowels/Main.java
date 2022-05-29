package edu.acc.java2.vowels;

import java.io.*;
import java.util.regex.*;

public class Main {
	private static final int A = 0, E = 1, I = 2, O = 3, U = 4;
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java -jar vowels.jar <text file>");
			return;
		}
		int[] vowelCounts = new int[5];
		try {
			//populate(vowelCounts, args[0]);
			//display(vowelCounts);
			palindromes(args[0]);
		}
		catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	
	private static void slowPopulate(int[] counts, String file) 
			throws IOException {
				
		try (FileReader fr = new FileReader(file)) {
			int theByte;
			long start = System.nanoTime();
			while ((theByte = fr.read()) != -1) {
				switch ((char)theByte) {
					case 'A': case 'a': counts[A]++; break;
					case 'E': case 'e': counts[E]++; break;
					case 'I': case 'i': counts[I]++; break;
					case 'O': case 'o': counts[O]++; break;
					case 'U': case 'u': counts[U]++; break;
					
				}
			}
			long end = System.nanoTime();
			System.out.printf("\n(elapsed time: %.3f seconds\n",
				(end - start)/1_000_000_000.0);
		}
	}	
	
	private static void populate(int[] counts, String file)
			throws IOException {
		try (BufferedReader br = new BufferedReader(
				new FileReader(file))) {
			String line;
			long start = System.nanoTime();
			while ((line = br.readLine()) != null) {
				for (int i = 0; i < line.length(); i++) {
					switch (line.charAt(i)) {
						case 'A': case 'a': counts[A]++; break;
						case 'E': case 'e': counts[E]++; break;
						case 'I': case 'i': counts[I]++; break;
						case 'O': case 'o': counts[O]++; break;
						case 'U': case 'u': counts[U]++; break;
					}
				}
			}
			long end = System.nanoTime();
			System.out.printf("\n\n(time elapsed: %.3f seconds\n",
				(end-start)/1_000_000_000.0 );
		}
	}
	
	private static void display(int[] counts) {
		int total = 0;
		final String format = "\n%s: %d";
		String[] vowels = {"A", "E", "I", "O", "U"};
		for (int i = 0; i < vowels.length; i++) {
			System.out.printf(format, vowels[i], counts[i]);
			total += counts[i];
		}
		System.out.printf("\n\nTotal vowels: %d\n", total);
	}
	
	private static void palindromes(String file)
		throws IOException {
		try (BufferedReader br = new BufferedReader(
				new FileReader(file))) {
			String line;
			long start = System.nanoTime();
			while ((line = br.readLine()) != null) {	
				for (int i = 3; i <= 9; i++) {
					check(line, i);
				}
			}
		}
	}
	
	private static void check(String line, int i) {
		String regex = "\\b";
		for (int j = 0; j < i/2; j++)
			regex += "(\\w)";
		if (i % 2 != 0)
			regex += "\\w";
		for (int j = i/2; j > 0; j--)
			regex += "\\" + j;
		regex += "\\b";
		Pattern patt = Pattern.compile(regex);
		Matcher m = patt.matcher(line);
		while (m.find())
			System.out.println("Palindrome! " + m.group());
	}
}








