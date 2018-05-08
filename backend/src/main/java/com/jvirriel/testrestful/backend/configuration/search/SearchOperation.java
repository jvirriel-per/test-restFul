package com.jvirriel.testrestful.backend.configuration.search;

import com.jvirriel.testrestful.commons.constants.SearchConstants;

public enum SearchOperation {
    BEGIN_WITH(SearchConstants.ASTERISK_SIGN),
    CONTAINS(SearchConstants.ASTERISK_SIGN),
    DISTINC(SearchConstants.NEQ),
    END_WITH(SearchConstants.ASTERISK_SIGN),
    EQUALS(SearchConstants.EQ),
    GREATER_THAN(SearchConstants.GT),
    GREATER_THAN_OR_EQUAL_TO(SearchConstants.GE),
    IN(SearchConstants.IN),
    LESS_THAN(SearchConstants.LT),
    LESS_THAN_OR_EQUAL_TO(SearchConstants.LE),
    OUT(SearchConstants.OUT),
    UNDEFINED(SearchConstants.UND);

    private String operation;

    private SearchOperation(String operation) {
        this.operation = operation;
    }

    public String toString() {
        return this.operation;
    }
}
