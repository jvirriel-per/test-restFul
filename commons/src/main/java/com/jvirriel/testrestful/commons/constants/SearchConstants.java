package com.jvirriel.testrestful.commons.constants;

public class SearchConstants {
    // General
    public static final String COMMA_SEPARATOR = ",";
    public static final String QUESTION_MARK = "?";
    public static final String SEMI_COLON_SEPARATOR = ";";
    public static final String SORT_DIRECTION_ASC = "asc";
    public static final String SORT_DIRECTION_DESC = "desc";

    // Regular Expressions
    public static final String CRITERIA_ORDER_BY_REGEX = "(\\w+?)(:)(asc|desc),";

    // RSQL Operator
    public static final String EQ = "==";
    public static final String NEQ = "!=";
    public static final String GE = ">=";
    public static final String GT = ">";
    public static final String LE = "<=";
    public static final String LT = "<";
    public static final String IN = "=in=";
    public static final String OUT = "=out=";
    public static final String UND = "!!";

    // Signs
    public static final String ASTERISK_SIGN = "*";
    public static final String EQUALS_SIGN = "=";

    // Strings
    public static final String ORDER_BY_STRING = "order by";
    public static final String SEARCH_STRING = "search";
}
