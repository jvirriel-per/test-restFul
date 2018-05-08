package com.jvirriel.testrestful.backend.configuration.assessment.predicates;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Predicate;

import static com.jvirriel.testrestful.backend.configuration.assessment.constants.StringConstants.LOWERS;
import static com.jvirriel.testrestful.backend.configuration.assessment.constants.StringConstants.NUMBERS;
import static com.jvirriel.testrestful.backend.configuration.assessment.constants.StringConstants.UPPERS;

public class StringPredicates {
	/* Type of String Predicates */

	public static Predicate<String> isAlpha() {
		return s -> StringUtils.isAlpha(s);
	}

	public static Predicate<String> isAlphaNumeric() {
		return s -> StringUtils.isAlphanumeric(s);
	}

	public static Predicate<String> isAlphaNumericSpace() {
		return s -> StringUtils.isAlphanumericSpace(s);
	}

	public static Predicate<String> isAlphaSpace() {
		return s -> StringUtils.isAlphaSpace(s);
	}

	public static Predicate<String> isNumeric() {
		return s -> StringUtils.isNumeric(s);
	}

	public static Predicate<String> isNumericSpace() {
		return s -> StringUtils.isNumericSpace(s);
	}

	public static Predicate<String> isWhiteSpace() {
		return s -> StringUtils.isWhitespace(s);
	}

	/* Emptiness and Nullity Predicates */

	public static Predicate<String> isBlank() {
		return s -> StringUtils.isBlank(s);
	}

	public static Predicate<String> isEmpty() {
		return s -> StringUtils.isEmpty(s);
	}

	public static Predicate<String> isNull() {
		return s -> s == null;
	}

	public static Predicate<String> isNotBlank() {
		return s -> StringUtils.isNotBlank(s);
	}

	public static Predicate<String> isNotEmpty() {
		return s -> StringUtils.isNotEmpty(s);
	}

	public static Predicate<String> isNotNull() {
		return s -> s != null;
	}

	/* Case Predicates */

	public static Predicate<String> isLowerCase() {
		return s -> StringUtils.isAllLowerCase(s);
	}

	public static Predicate<String> isUpperCase() {
		return s -> StringUtils.isAllUpperCase(s);
	}

	/* Length Predicates */

	public static Predicate<String> isLong(int numberOfChars) {
		return s -> s.length() == numberOfChars;
	}

	public static Predicate<String> isLongerThan(int minNumberOfChars) {
		return s -> s.length() > minNumberOfChars;
	}

	public static Predicate<String> isLongerThanOrEqualTo(int minNumberOfChars) {
		return s -> s.length() >= minNumberOfChars;
	}

	public static Predicate<String> isShorterThan(int maxNumberOfChars) {
		return s -> s.length() < maxNumberOfChars;
	}

	public static Predicate<String> isShorterThanOrEqualTo(int maxNumberOfChars) {
		return s -> s.length() <= maxNumberOfChars;
	}

	public static Predicate<String> isBetween(int minNumberOfChars, int maxNumberOfChars) {
		return s -> minNumberOfChars <= s.length() && s.length() <= maxNumberOfChars;
	}

	/* Content Predicates */

    public static Predicate<String> beginsWithAlpha() {
        return s -> StringUtils.indexOf(s, LOWERS) == 0 || StringUtils.indexOf(s, UPPERS) == 0;
    }

	public static Predicate<String> beginsWithLower() {
		return s -> StringUtils.indexOf(s, LOWERS) == 0;
	}

    public static Predicate<String> beginsWithNumber() {
        return s -> StringUtils.indexOf(s, NUMBERS) == 0;
    }

	public static Predicate<String> beginsWithUpper() {
		return s -> StringUtils.indexOf(s, UPPERS) == 0;
	}

	public static Predicate<String> containsAny(String searchCharacters) {
		return s -> StringUtils.containsAny(s, searchCharacters);
	}

	public static Predicate<String> containsNone(String invalidCharacters) {
		return s -> StringUtils.containsNone(s, invalidCharacters);
	}

	public static Predicate<String> containsOnly(String validCharacters) {
		return s -> StringUtils.containsOnly(s, validCharacters);
	}

	public static Predicate<String> matchesRegEx(String regex) {
        return s -> s.matches(regex) == true;
    }
}
