package com.jvirriel.testrestful.commons.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class SingleResourceRetrieved extends ApplicationEvent {
    private HttpServletResponse response;

    public SingleResourceRetrieved(Object source) {
        super(source);
    }

    public HttpServletResponse getResponse() {
        return response;
    }


}
