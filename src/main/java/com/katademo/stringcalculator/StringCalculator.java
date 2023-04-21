package com.katademo.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public static int add(String stringOfNumbers) {
		if (stringOfNumbers.isEmpty())
			return 0;

		String[] numbers = extractNumbersFrom(stringOfNumbers);

		return sum(numbers);
	}

	private static String[] extractNumbersFrom(String stringOfNumbers) {
		String delimiter = ",";
		if (hasCustomDelimiterSection(stringOfNumbers)) {
			String[] tokens = stringOfNumbers.split("\n", 2);
			delimiter = extract_delimiter_from(tokens[0]);
			stringOfNumbers = tokens[1];
		}
		return stringOfNumbers.replaceAll("\n", delimiter).split(delimiter);
	}

	private static boolean hasCustomDelimiterSection(String stringOfNumbers) {
		return stringOfNumbers.startsWith("//");
	}

	private static String extract_delimiter_from(String delimiterSection) {
		Pattern pattern = Pattern.compile("//\\[(.+)\\]");
		Matcher matcher = pattern.matcher(delimiterSection);
		matcher.matches();
		return Pattern.quote(matcher.group(1));
	}

	private static int sum(String[] numbers) {
		int sum = 0;
		for (String eachNumber : numbers) {
			sum += Integer.valueOf(eachNumber);
		}
		return sum;
	}
}
