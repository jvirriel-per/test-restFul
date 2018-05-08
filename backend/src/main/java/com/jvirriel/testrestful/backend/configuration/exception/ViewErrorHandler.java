package com.jvirriel.testrestful.backend.configuration.exception;

import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.ErrorEvent;

public class ViewErrorHandler extends DefaultErrorHandler {
    @Override
    public void error(ErrorEvent event) {
        String cause = "Error debido a: "+"\n";
        for (Throwable t = event.getThrowable(); t != null;
             t = t.getCause())
            if (t.getCause() == null)
                cause += t.getClass().getName();
        System.out.println("Ocurrió el error "+cause);
    }


}
