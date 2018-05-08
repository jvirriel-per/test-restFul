package com.jvirriel.testrestful.backend.configuration.assessment.verifiers;

import com.jvirriel.testrestful.backend.configuration.assessment.tuples.PredicatePair;

import static java.lang.Boolean.*;

/**
 * BooleanEvaluator.java

 */
public class BooleanEvaluator {
    private Boolean eval;

    private BooleanEvaluator(Boolean eval) {
        this.eval = eval;
    }

    /* Boolean Evaluator Initializers. */

    public static BooleanEvaluator setToFalse() {
        return new BooleanEvaluator(FALSE);
    }

    public static BooleanEvaluator setToTrue() {
        return new BooleanEvaluator(TRUE);
    }

    public static BooleanEvaluator setProposition(Boolean eval) {
        return new BooleanEvaluator(eval);
    }

    public static <T> BooleanEvaluator setProposition(PredicatePair<T> pair) {
        return new BooleanEvaluator(pair.getPredicate().test(pair.getSubject()));
    }

    /* Boolean Evaluator Negations. */

    // General negation.

    public BooleanEvaluator negate() {
        this.eval = !this.eval;

        return this;
    }

    // Negations over arrays of booleans

    public BooleanEvaluator andNot(Boolean expression) {
        this.eval = logicalAnd(this.eval, !expression);

        return this;
    }

    public BooleanEvaluator orNot(Boolean expression) {
        this.eval = logicalOr(this.eval, !expression);

        return this;
    }

    public BooleanEvaluator nand(Boolean expression) {
        this.eval = !logicalAnd(this.eval, expression);

        return this;
    }

    public BooleanEvaluator nor(Boolean expression) {
        this.eval = !logicalOr(this.eval, expression);

        return this;
    }

    // Negations over pairs of the form (Predicate of T, t of type T)

    public <T> BooleanEvaluator andNot(PredicatePair<T> pair) {
        this.eval = logicalAnd(this.eval, !pair.getPredicate().test(pair.getSubject()));

        return this;
    }

    public <T> BooleanEvaluator orNot(PredicatePair<T> pair) {
        this.eval = logicalOr(this.eval, !pair.getPredicate().test(pair.getSubject()));

        return this;
    }

    public <T> BooleanEvaluator nand(PredicatePair<T> pair) {
        this.eval = !logicalAnd(this.eval, pair.getPredicate().test(pair.getSubject()));

        return this;
    }

    public <T> BooleanEvaluator nor(PredicatePair<T> pair) {
        this.eval = !logicalOr(this.eval, pair.getPredicate().test(pair.getSubject()));

        return this;
    }

    // Evaluator with array of booleans.

    public BooleanEvaluator and(Boolean expression) {
        this.eval = logicalAnd(this.eval, expression);

        return this;
    }

    public BooleanEvaluator or(Boolean expression) {
        this.eval = logicalOr(this.eval, expression);

        return this;
    }

    public BooleanEvaluator xor(Boolean expression) {
        this.eval = logicalXor(this.eval, expression);

        return this;
    }

    // Evaluator with pair of predicates.

    public <T> BooleanEvaluator and(PredicatePair<T> pair) {
        this.eval = logicalAnd(this.eval, pair.getPredicate().test(pair.getSubject()));

        return this;
}

    public <T> BooleanEvaluator or(PredicatePair<T> pair) {
        this.eval = logicalOr(this.eval, pair.getPredicate().test(pair.getSubject()));

        return this;
}

    public <T> BooleanEvaluator xor(PredicatePair<T> pair) {
        this.eval = logicalXor(this.eval, pair.getPredicate().test(pair.getSubject()));

        return this;
    }

    // Evaluate.

    public final Boolean evaluate() {
        return this.eval;
    }
}