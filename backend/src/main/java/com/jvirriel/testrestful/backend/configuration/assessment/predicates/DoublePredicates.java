package com.jvirriel.testrestful.backend.configuration.assessment.predicates;

import java.util.function.Predicate;

public class DoublePredicates {
	public static Predicate<Double> isGreaterThan(Double value) {
		return d -> d > value;
	}

	public static Predicate<Double> isGreaterThanOrEqualTo(Double value) {
		return d -> d >= value;
	}

	public static Predicate<Double> isInClosedInterval(Double left, Double right) {
		return d -> left <= d && d <= right;
	}

	public static Predicate<Double> isInLeftClosedRightOpenInterval(Double left, Double right) {
		return d -> left <= d && d < right;
	}

	public static Predicate<Double> isInLeftOpenRightClosedInterval(Double left, Double right) {
		return d -> left < d && d <= right;
	}

	public static Predicate<Double> isInOpenInterval(Double left, Double right) {
		return d -> left < d && d < right;
	}

	public static Predicate<Double> isLessThan(Double value) {
		return d -> d < value;
	}

	public static Predicate<Double> isLessThanOrEqualTo(Double value) {
		return d -> d <= value;
	}

	public static Predicate<Double> isNegative() {
		return d -> d < 0;
	}

	public static Predicate<Double> isNonNegative() {
		return d -> d >= 0;
	}

	public static Predicate<Double> isNonPositive() {
		return d -> d <= 0;
	}
	
	public static Predicate<Double> isNotNull() {
		return d -> d != null;
	}
	
	public static Predicate<Double> isNull() {
		return d -> d == null;
	}

	public static Predicate<Double> isPositive() {
		return d -> d > 0;
	}
}
