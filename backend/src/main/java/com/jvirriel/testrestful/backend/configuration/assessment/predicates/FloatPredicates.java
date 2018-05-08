package com.jvirriel.testrestful.backend.configuration.assessment.predicates;

import java.util.function.Predicate;

public class FloatPredicates {
	public static Predicate<Float> isGreaterThan(Float value) {
		return f -> f > value;
	}

	public static Predicate<Float> isGreaterThanOrEqualTo(Float value) {
		return f -> f >= value;
	}

	public static Predicate<Float> isInClosedInterval(Float left, Float right) {
		return f -> left <= f && f <= right;
	}

	public static Predicate<Float> isInLeftClosedRightOpenInterval(Float left, Float right) {
		return f -> left <= f && f < right;
	}

	public static Predicate<Float> isInLeftOpenRightClosedInterval(Float left, Float right) {
		return f -> left < f && f <= right;
	}

	public static Predicate<Float> isInOpenInterval(Float left, Float right) {
		return f -> left < f && f < right;
	}

	public static Predicate<Float> isLessThan(Float value) {
		return f -> f < value;
	}

	public static Predicate<Float> isLessThanOrEqualTo(Float value) {
		return f -> f <= value;
	}

	public static Predicate<Float> isNegative() {
		return f -> f < 0;
	}

	public static Predicate<Float> isNonNegative() {
		return f -> f >= 0;
	}

	public static Predicate<Float> isNonPositive() {
		return f -> f <= 0;
	}
	
	public static Predicate<Float> isNotNull() {
		return f -> f != null;
	}
	
	public static Predicate<Float> isNull() {
		return f -> f == null;
	}

	public static Predicate<Float> isPositive() {
		return f -> f > 0;
	}
}
