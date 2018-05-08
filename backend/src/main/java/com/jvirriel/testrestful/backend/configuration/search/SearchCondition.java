package com.jvirriel.testrestful.backend.configuration.search;

import com.jvirriel.testrestful.commons.constants.SearchConstants;

import static com.jvirriel.testrestful.backend.configuration.search.SearchOperation.*;

public class SearchCondition {

    private String key;
    private SearchOperation operation;
    private String value;

    public SearchCondition() {

    }

    public SearchCondition(final String key, final SearchOperation operation, final String value) {
        super();
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public SearchCondition(final String key, final String operation, final String value) {
        super();
        this.key = key;
        this.operation = fromStringToSearchOperation(operation);
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public SearchOperation getOperation() {
        return operation;
    }

    public void setOperation(final SearchOperation operation) {
        this.operation = operation;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String result = "";
        switch (operation) {
            case BEGIN_WITH:
                result = makeSearchConditionString(key, EQUALS.toString(), value.concat(operation.toString()));
                break;
            case CONTAINS:
                result = makeSearchConditionString(key, EQUALS.toString(),
                        operation.toString().concat(value).concat(operation.toString()));
                break;
            case END_WITH:
                result = makeSearchConditionString(key, EQUALS.toString(), operation.toString().concat(value));
                break;
            case DISTINC:
            case EQUALS:
            case GREATER_THAN:
            case GREATER_THAN_OR_EQUAL_TO:
            case LESS_THAN:
            case LESS_THAN_OR_EQUAL_TO:
                result = makeSearchConditionString(key, operation.toString(), value);
                break;
            case IN:
            case OUT:
                result = makeSearchConditionString(key, operation.toString(), value);
        }

        return result;
    }

    private SearchOperation fromStringToSearchOperation(String operation) {
        switch (operation) {
            case SearchConstants.ASTERISK_SIGN:
                return CONTAINS;
            case SearchConstants.NEQ:
                return DISTINC;
            case SearchConstants.EQ:
                return EQUALS;
            case SearchConstants.GT:
                return GREATER_THAN;
            case SearchConstants.GE:
                return GREATER_THAN_OR_EQUAL_TO;
            case SearchConstants.LT:
                return LESS_THAN;
            case SearchConstants.LE:
                return LESS_THAN_OR_EQUAL_TO;
            case SearchConstants.OUT:
                return OUT;
            default:
                return UNDEFINED;
        }
    }

    private String makeSearchConditionString(String key, String operation, String value) {
        return key.concat(operation).concat(value);
    }
}
