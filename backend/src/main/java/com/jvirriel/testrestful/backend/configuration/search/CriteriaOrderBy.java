package com.jvirriel.testrestful.backend.configuration.search;

import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.jvirriel.testrestful.commons.constants.SearchConstants.*;
import static org.springframework.data.domain.Sort.Direction;
import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;
import static org.springframework.data.domain.Sort.Order;


public class CriteriaOrderBy {
    /**
     * @param rpOrderby Cadena de caracteres que contiene una expresion regular que indica
     *                  el criterio de ordenamiento a ser aplicado.
     * @param jpqlBase  Consulta base sobre la cual se aplicará un criterio de ordenamiento
     *                  basado en uno o más campos de la tabla persistida.
     * @return Una cadena de caracteres que respresenta una consulta expresada en JPQL la
     * cual retorna un conjunto de resultados ordenados ascendente o descendentemente, segun
     * uno o más campos de la tabla persistida.
     */
    public static String getOrderedQuery(final String rpOrderby, final String jpqlBase) {
        String jpqlOrder;
        String jpql;

        List<SearchCondition> paramsSearch = getSearchParameters(rpOrderby);

        jpqlOrder = ORDER_BY_STRING.concat(" ");

        if (paramsSearch.size() > 0) {
            Iterator<SearchCondition> searchConditionIterator = paramsSearch.iterator();

            while (searchConditionIterator.hasNext()) {
                SearchCondition searchCondition = searchConditionIterator.next();
                jpqlOrder = jpqlOrder
                        .concat(searchCondition.getKey())
                        .concat(" ")
                        .concat(searchCondition.getValue())
                        .concat(searchConditionIterator.hasNext() ? COMMA_SEPARATOR : "");
            }
        }

        jpql = jpqlBase.concat(paramsSearch.size() == 0 ? "" : jpqlOrder);

        return jpql;
    }

    /**
     * @param rpOrderby Cadena de caracteres que contiene una expresion regular que indica
     *                  el criterio de ordenamiento a ser aplicado.
     * @return Retorna una instancia de la clase Sort la cual permite especificar un criterio
     * de ordeniamiento, seguido de la dirección (ascendente o descente) en la que se debera
     * realizar la operacion.
     */
    public static Sort getSortConditions(String rpOrderby) {
        List<Order> sortCriteria = new ArrayList<>();

        List<SearchCondition> paramsSearch = getSearchParameters(rpOrderby);

        Direction sortDirection;
        for (SearchCondition condition : paramsSearch) {
            sortDirection = condition.getValue().equals(SORT_DIRECTION_ASC) ? ASC : DESC;
            sortCriteria.add(new Order(sortDirection, condition.getKey()));
        }

        return new Sort(sortCriteria);
    }

    /**
     * @param stringToMatch Cadena de caracteres que contiene criterios de ordenamiento de la forma
     *                      key:direction donde key es un atributo de la tabla persistida y direction
     *                      adquiere uno de dos valores asc | desc para realizar ordenamientos ascendentes
     *                      o descendentes segun sea el caso.
     * @return Retorna una lista de condicoines de búsqueda.
     */
    private static List<SearchCondition> getSearchParameters(String stringToMatch) {
        List<SearchCondition> paramsSearch = new ArrayList<>();

        if (Objects.nonNull(stringToMatch)) {
            Pattern pattern = Pattern.compile(CRITERIA_ORDER_BY_REGEX);
            Matcher matcher = pattern.matcher(stringToMatch.concat(COMMA_SEPARATOR));

            while (matcher.find()) {
                paramsSearch.add(new SearchCondition(matcher.group(1), matcher.group(2), matcher.group(3)));
            }
        }

        return paramsSearch;
    }
}