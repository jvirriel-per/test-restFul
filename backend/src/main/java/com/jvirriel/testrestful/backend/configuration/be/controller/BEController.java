package com.jvirriel.testrestful.backend.configuration.be.controller;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * BEController.java
 *
 * Interface que bosqueja la estructura general del Controller de una Back-End para
 * una entidad persistida con JPA, exhibiendo las operaciones CRUD básicas para
 * obtener todos los registros, obtener uno en particular, insertar, actualizar y
 * eliminar.
 * @param <T> Generics correspondiente a la clase de la entidad persistida con JPA
 * @param <ID> Generics correspondiente a la clase del tipo de id de la entidad.
 *            en principio, puede ser de tipo Integer o Long.
 */
public interface BEController<T, ID> {
    /**
     * Borra una entidad dado su id.
     *
     * @param id id de la entidad a ser eliminada
     * @return ResponseEntity con un código de éxito o de error.
     */
    ResponseEntity<?> delete(ID id, HttpServletRequest request);


    /**
     * Obtiene todos los usuarios según uno o más criterios de búsqueda u ordenamiento (o ambos).
     *
     * @param search Expresión en RSQL para hacer consultas a través de servicios RESTful
     * @param orderBy Criterio de ordenamiento ascedente o descendente según uno o más atributos de la entidad.
     * @param page Número de página a devolver en una grid. Por defecto adquiere el valor de 1.
     * @param size Número de entidades recuperadas por cada página. Por defecto tiene el valor de 10.
     * @return ResponseEntity con una lista de los objetos recuperados.
     */
    ResponseEntity<List<T>> findAll(String search, String orderBy, String page, String size, HttpServletRequest request);

    /**
     * Obtiene un entidad específica según su id.
     *
     * @param id id de la entidad a ser recuperada, en caso de que la misma exista.
     * @return ResponseEntity con la entidad recuperada o un código de error según sea el caso.
     */
    ResponseEntity<?> findById(ID id, HttpServletRequest request);

    /**
     * Dada una entidad, inserta la misma en la base de datos.
     *
     * @param entity Entidad a ser insertada en la base de datos.
     * @return ResponseEntity con la entidad insertada.
     */
    ResponseEntity<?> save(T entity, HttpServletRequest request);

    /**
     * Dada una entidad, la actualiza en caso de ya existir en la base de datos.
     *
     * @param id id de la entidad a ser actualizada
     * @param entity entidad a ser actualizada con los datos modificados.
     * @return ResponseEntity con la entidad actualizada
     */
    ResponseEntity<?> update(ID id, T entity, HttpServletRequest request);
}
