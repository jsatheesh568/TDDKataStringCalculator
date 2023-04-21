package com.katademo.stringcalculator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

	@Test
	public void isZeroForAnEmptyString() {
		verifyAdd(0, "");
	}

	@Test
	public void isJustTheNumberForAStringWithJustTheNumber() {
		verifyAdd(1, "1");
	}

	@Test
	public void sumsTheTwoNumbersForAStringOfCommaSeparatedNumbers() {
		verifyAdd(3, "1,2");
	}

	@Test
	public void sumsAnUnknownAmountOfCommaSeparatedNumbers() {
		verifyAdd(1 + 2 + 3 + 4, "1,2,3,4");
	}

	@Test
	public void canHandleNewLinesAsNumberDelimiter() {
		verifyAdd(1 + 2 + 3 + 4, "1\n2,3\n4");
	}

	@Test
	public void supportsDifferentDelimiters() throws Exception {
		verifyAdd(1 + 2 + 3 + 4, "//[***]\n1***2***3***4");
	}

	private void verifyAdd(int expected, String stringOfNumbers) {
		int result = StringCalculator.add(stringOfNumbers);
		assertEquals(expected, result);
	}
}
