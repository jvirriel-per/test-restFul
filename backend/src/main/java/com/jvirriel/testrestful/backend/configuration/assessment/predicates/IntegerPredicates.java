package com.jvirriel.testrestful.backend.configuration.assessment.predicates;

import java.util.function.Predicate;

public class IntegerPredicates {
	public static Predicate<Integer> isGreaterThan(Integer value) {
		return i -> i > value;
	}

	public static Predicate<Integer> isGreaterThanOrEqualTo(Integer value) {
		return i -> i >= value;
	}

	public static Predicate<Integer> isInClosedInterval(Integer left, Integer right) {
		return i -> left <= i && i <= right;
	}

	public static Predicate<Integer> isInLeftClosedRightOpenInterval(Integer left, Integer right) {
		return i -> left <= i && i < right;
	}

	public static Predicate<Integer> isInLeftOpenRightClosedInterval(Integer left, Integer right) {
		return i -> left < i && i <= right;
	}

	public static Predicate<Integer> isInOpenInterval(Integer left, Integer right) {
		return i -> left < i && i < right;
	}

	public static Predicate<Integer> isLessThan(Integer value) {
		return i -> i < value;
	}

	public static Predicate<Integer> isLessThanOrEqualTo(Integer value) {
		return i -> i <= value;
	}

	public static Predicate<Integer> isNegative() {
		return i -> i < 0;
	}

	public static Predicate<Integer> isNonNegative() {
		return i -> i >= 0;
	}

	public static Predicate<Integer> isNonPositive() {
		return i -> i <= 0;
	}
	
	public static Predicate<Integer> isNotNull() {
		return i -> i != null;
	}
	
	public static Predicate<Integer> isNull() {
		return i -> i == null;
	}

	public static Predicate<Integer> isPositive() {
		return i -> i > 0;
	}
}
