package com.jvirriel.testrestful.backend.configuration.be.service;

import java.util.List;

import static java.lang.Boolean.FALSE;

/**
 * BEService.java
 *
 * Interface que bosqueja la estructura general del Service de una Back-End para
 * una entidad persistida con JPA, exhibiendo las operaciones CRUD básicas para
 * obtener todos los registros, obtener uno en particular, insertar/actualizar,
 * eliminar y consultar existencia.

 * @param <T> Generics correspondiente a la clase de la entidad persistida con JPA
 * @param <ID> Generics correspondiente a la clase del tipo de id de la entidad.
 *            en principio, puede ser de tipo Integer o Long.
 */
public interface BEService<T, ID> {
    /**
     * Borra una entidad dado su id.
     *
     * @param id id de la entidad a ser eliminada
     */
    void delete(ID id);

    /**
     * Verifica la existencia de una entidad en la base de datos.
     *
     * @param id id de la entidad que se va a verificar.
     * @return Verdadero o falso sin la prueba de existencia de la entidad.
     */
    default Boolean exists(ID id) {
        return FALSE;
    }

    /**
     * Obtiene todos los usuarios según uno o más criterios de búsqueda u ordenamiento (o ambos).
     *
     * @param search Expresión en RSQL para hacer consultas a través de servicios RESTful
     * @param orderBy Criterio de ordenamiento ascedente o descendente según uno o más atributos de la entidad.
     * @param page Número de página a devolver en una grid. Por defecto adquiere el valor de 1.
     * @param size Número de entidades recuperadas por cada página. Por defecto tiene el valor de 10.
     * @return Una lista de los objetos recuperados.
     */
    List<T> findAll(String search, String orderBy, String page, String size);

    /**
     * Obtiene un entidad específica según su id.
     *
     * @param id id de la entidad a ser recuperada, en caso de que la misma exista.
     * @return Entidad recuperada de la base de datos.
     */
    T findById(ID id);

    /**
     * Dada una entidad, inserta o actualiza la misma en la base de datos.
     *
     * @param entity Entidad a ser insertada/actualizada en la base de datos.
     * @return Entidad insertada/actualizada.
     */
    T save(T entity);
}
