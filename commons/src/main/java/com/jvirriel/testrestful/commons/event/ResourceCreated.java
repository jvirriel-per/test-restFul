package com.jvirriel.testrestful.commons.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;


public class ResourceCreated extends ApplicationEvent {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private HttpServletResponse response;
    private long idOfNewResource;

    public void setIdOfNewResource(long idOfNewResource) {
        this.idOfNewResource = idOfNewResource;
    }

    public ResourceCreated(Object source,
                           HttpServletResponse response, long idOfNewResource) {
        super(source);

        this.response = response;
        logger.info("Evento");
        this.idOfNewResource = idOfNewResource;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public long getIdOfNewResource() {
        return idOfNewResource;
    }
}
