package com.jvirriel.testrestful.backend;

import com.jvirriel.testrestful.backend.bus.Producer;
import com.jvirriel.testrestful.backend.configuration.be.controller.BEController;
import com.jvirriel.testrestful.backend.configuration.exception.CustomErrorType;
import com.jvirriel.testrestful.commons.event.ResourceCreated;
import com.jvirriel.testrestful.model.Users;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.jvirriel.testrestful.backend.UsersConstants.USERS;
import static com.jvirriel.testrestful.backend.configuration.BackEndConstants.*;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(value= API + USERS)
public class UsersController implements BEController<Users, Long> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ApplicationEventPublisher eventPublisher;
    private final UsersServices services;
    private final Ignite ignite;
    private final Producer producer;

    @PersistenceContext()
    private EntityManager entityManager;

    @Autowired
    public UsersController(ApplicationEventPublisher eventPublisher, UsersServices services,
                           Ignite ignite, Producer producer){
        this.services = services;
        this.eventPublisher = eventPublisher;
        this.ignite = ignite;
        this.producer = producer;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id, HttpServletRequest request) {
        if (!services.exists(id)) {
            return new ResponseEntity<>(
                    CustomErrorType.get("Unable to delete. User with id " + id + " not found."),
                    NOT_FOUND
            );
        }

        services.delete(id);

        return new ResponseEntity<Users>(NO_CONTENT);
    }

    // ------------------- Search All Users ---------------------------------------------

    @GetMapping
    public ResponseEntity<List<Users>> findAll(
            @RequestHeader(value = "search", defaultValue = DEFAULT_SEARCH) String search,
            @RequestHeader(value = "orderBy", defaultValue = DEFAULT_ORDER_BY) String orderBy,
            @RequestHeader(value = "page", defaultValue = DEFAULT_PAGE) String page,
            @RequestHeader(value = "size", defaultValue = DEFAULT_SIZE) String size,
            HttpServletRequest request) {

        List<Users> result;

        result = services.findAll(search, orderBy, page, size);

        if (result.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }

        return new ResponseEntity<>(result, OK);
    }

    // -------------------Retrieve Entity Status------------------------------------------

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id, HttpServletRequest request) {
        if (!services.exists(id)) {

            return new ResponseEntity<>(
                    CustomErrorType.get("Entity Status with id " + id + " not found"),
                    NOT_FOUND
            );
        }

        return new ResponseEntity<>(services.findById(id), OK);
    }

    // -------------------Create  Users-------------------------------------------

    @PostMapping(value = "/")
    public ResponseEntity<?> save(@RequestBody Users users, HttpServletRequest request) {
        boolean nullEntity = users == null;
        String errorMessage;

        if (nullEntity) {
            errorMessage = "Empty entity Status.";
        } else if (users.getId() != null) {
            errorMessage = "Entity Status must not have Id for Save, use Update instead.";
        } else {
            return new ResponseEntity<>(services.save(users), CREATED);
        }

        return new ResponseEntity<>(
                CustomErrorType.get(400, errorMessage),
                BAD_REQUEST
        );
    }

    // ------------------- Update an Users ------------------------------------------------

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id,
                                    @RequestBody Users users, HttpServletRequest request) {
        if (!services.exists(id)) {
            return new ResponseEntity<>(
                    CustomErrorType.get("Unable to update. User with id " + id + " not found."),
                    NOT_FOUND
            );
        }

        return new ResponseEntity<>(services.save(users), OK);
    }

    // ------------------- Process an action-----------------------------------------

    @PostMapping(
            value = "/process/{action}")
    public ResponseEntity<String> processUsersByProcess(
            @PathVariable("action") String action,
            HttpServletResponse response
    ) {
        logger.info("*** process: " + action + " ***");

        ResourceCreated resourceCreated = new ResourceCreated(this, response, 7);
        eventPublisher.publishEvent(resourceCreated);


        return new ResponseEntity<>("Respuesta" + action + resourceCreated.getIdOfNewResource(), OK);
    }

    @PostMapping(
            value = "/publicer/{action}")
    public ResponseEntity<String> publicerUsersByProcess(
            @PathVariable("action") String action,
            HttpServletResponse response
    ) {
        logger.info("*** publicar: " + action + " ***");
        Users users = new Users();
        users.setCodigo("Kafka");
        users.setClaseentidad(action);
        producer.send("t.general", users.toString());
        producer.send("test2", action);

        logger.info("*** Cache ***");
        try (IgniteCache<Integer, String> cache = ignite.getOrCreateCache("MyCache")) {
            logger.info("*** Cache Registro***");
            for (int i = 0; i < 10; i++) {
                cache.put(i, Integer.toString(i));
            }

            for (int i = 0; i < 10; i++) {
                logger.info("Obtener [key=" + i + ", val=" + cache.get(i) + ']');
            }
        }

        return new ResponseEntity<>("Respuesta" + action, OK);
    }

    @ExceptionHandler(NullPointerException.class)
    void handleBadRequest(HttpServletResponse response) throws IOException {
        response.sendError(BAD_REQUEST.value(), "Users not found, probably wrong ID");
    }
}
