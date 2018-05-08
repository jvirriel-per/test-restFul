package com.jvirriel.testrestful.commons.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
class ResourceCreatedDiscoverabilityListener
        implements ApplicationListener<ResourceCreated> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onApplicationEvent(ResourceCreated resourceCreatedEvent) {
        logger.info("*** Escucha Evento Resource Created ");

        HttpServletResponse response = resourceCreatedEvent.getResponse();
        long idOfNewResource = resourceCreatedEvent.getIdOfNewResource();

        addLinkHeaderOnResourceCreation(response, idOfNewResource);

        resourceCreatedEvent.setIdOfNewResource(8);
    }

    void addLinkHeaderOnResourceCreation
            (HttpServletResponse response, long idOfNewResource) {
        logger.info("********* entro");
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().
                path("/{idOfNewResource}").buildAndExpand(idOfNewResource).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}