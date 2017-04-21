package com.training.controller.input;

import static com.training.controller.input.Regex.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TestRegex {

	@DataPoints("validNicknames")
	public static String[] validNicknames = new String[] { "ssss", "ss_ss", "ss-ss", "s123", "ss.ss" };

	@Theory
	public void testValidNickname(@FromDataPoints("validNicknames") String testData) {
		assertTrue(testData.matches(NICKNAME_PATTERN.toString()));

	}

	@Test
	public void testNicknameLessThenFourChar() {
		assertFalse("ssd".matches(NICKNAME_PATTERN.toString()));
	}

	@Test
	public void testNicknameFirstNum() {
		assertFalse("1ssd".matches(NICKNAME_PATTERN.toString()));
	}

	@Test
	public void testNicknameWithSpaces() {
		assertFalse("ss ss".matches(NICKNAME_PATTERN.toString()));
	}

	@Test
	public void testValidNumber() {
		assertTrue("1111111111".matches(PHONE_PATTERN.toString()));
	}

	@DataPoints("invalidNumbers")
	public static String[] invalidNumbers = new String[] { "111111111", "11111111111" };

	@Theory()
	public void testInvalidNumbers(@FromDataPoints("invalidNumbers") String testData) {
		assertFalse(testData.matches(PHONE_PATTERN.toString()));

	}
}
