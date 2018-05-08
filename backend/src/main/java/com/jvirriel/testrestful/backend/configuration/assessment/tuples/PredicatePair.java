package com.jvirriel.testrestful.backend.configuration.assessment.tuples;

import java.util.function.Predicate;


public class PredicatePair<T> {
    private Predicate<T> predicate;
    private T subject;

    public PredicatePair() {}

    public PredicatePair(Predicate<T> predicate, T subject) {
        this.predicate = predicate;
        this.subject = subject;
    }

    public Predicate<T> getPredicate() {
        return predicate;
    }

    public void setPredicate(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    public T getSubject() {
        return subject;
    }

    public void setSubject(T subject) {
        this.subject = subject;
    }
}