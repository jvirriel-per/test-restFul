package com.jvirriel.testrestful.backend.configuration.assessment.predicates;

import java.util.function.Predicate;

public class LongPredicates {
	public static Predicate<Long> isGreaterThan(Long value) {
		return l -> l > value;
	}

	public static Predicate<Long> isGreaterThanOrEqualTo(Long value) {
		return l -> l >= value;
	}

	public static Predicate<Long> isInClosedInterval(Long left, Long right) {
		return l -> left <= l && l <= right;
	}

	public static Predicate<Long> isInLeftClosedRightOpenInterval(Long left, Long right) {
		return l -> left <= l && l < right;
	}

	public static Predicate<Long> isInLeftOpenRightClosedInterval(Long left, Long right) {
		return l -> left < l && l <= right;
	}

	public static Predicate<Long> isInOpenInterval(Long left, Long right) {
		return l -> left < l && l < right;
	}

	public static Predicate<Long> isLessThan(Long value) {
		return l -> l < value;
	}

	public static Predicate<Long> isLessThanOrEqualTo(Long value) {
		return l -> l <= value;
	}

	public static Predicate<Long> isNegative() {
		return l -> l < 0L;
	}

	public static Predicate<Long> isNonNegative() {
		return l -> l >= 0L;
	}

	public static Predicate<Long> isNonPositive() {
		return l -> l <= 0L;
	}
	
	public static Predicate<Long> isNotNull() {
		return l -> l != null;
	}
	
	public static Predicate<Long> isNull() {
		return l -> l == null;
	}

	public static Predicate<Long> isPositive() {
		return l -> l > 0L;
	}
}
