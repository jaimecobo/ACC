package edu.acc.java2.areacodes;

import java.io.*;
import java.util.regex.*;

public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java -jar areacodes.jar <great data area code file>");
			return;
		}
		try (BufferedReader br = new BufferedReader(
				new FileReader(args[0]))) {
			int texasAreaCodeCount = 0;
			/*
				Find 3 digits in a table data cell near the start of a line. Ignore
				an asterisk if there is one. Skip over stuff until we locate the
				word Texas in a table data cell, then skip over more stuff until
				we find the contents of the last table data cell in the line.
			*/
			String regex = "<td>(\\d{3})\\*?</td>.+<td>Texas</td>.+>(.+)</td>";
			/*
				Create a regular expression parser for this pattern.
			*/
			Pattern acPatt = Pattern.compile(regex);
			String line;
			while ((line = br.readLine()) != null) {
				/*
					Ask the pattern for a matcher with each line as a candidate.
				*/
				Matcher m = acPatt.matcher(line);
				/*
					If the matcher doesn't find our pattern, skip to the next line.
				*/
				if (!m.find()) continue;
				/*
					Here we have found a match, so the parentheses in our pattern form
					capturing groups. Group 1 is the area code (3 digits) and Group 2
					is the text describing the region.
				*/
				System.out.printf("(%s) %s\n", m.group(1), m.group(2));
				texasAreaCodeCount++;
			}
			System.out.printf("\n\nFound %d Texas area codes\n", 
				texasAreaCodeCount);
		}
		catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
}