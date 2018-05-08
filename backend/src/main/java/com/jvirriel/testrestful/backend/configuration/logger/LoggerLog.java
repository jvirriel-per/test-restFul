package com.jvirriel.testrestful.backend.configuration.logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;


/**
 * Entidad que contiene un error a ser loggeado a logger.
 */
public class LoggerLog {
    protected Date creationDate;
    protected String message;
    protected String stackTrace;

    /**
     * Constructor no parametrizado.
     * Debe setearsele el error con setUp antes de ser enviado.
     */
    public LoggerLog() {
    }

    /**
     * Construye el Log a partir de un throwable
     * @param throwable el error a loggearse.
     */
    public LoggerLog(Throwable throwable) {
        setUp(throwable);
    }

    /**
     * Constructor copia.
     * @param log elemento del cual copiarse.
     */
    public LoggerLog(LoggerLog log) {
        this.creationDate = log.creationDate;
        this.message = log.message;
        this.stackTrace = log.stackTrace;
    }

    /**
     * Setea el error a partir de un throwable.
     * @param throwable el error.
     */
    public void setUp(Throwable throwable){
        this.creationDate = new Date();
        this.message = throwable.getMessage();
        this.stackTrace = extractStackTrace(throwable);
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    /**
     * Imprime el StackTrace en un String.
     * @param throwable el throwable del cual extraer.
     * @return Retorna el StackTrace en forma de String.
     */
    private String extractStackTrace(Throwable throwable) {
        StringWriter causeValuesStringWriter = new StringWriter();
        PrintWriter causeValuesPrintWriter = new PrintWriter(causeValuesStringWriter);

        throwable.printStackTrace(causeValuesPrintWriter);
        causeValuesPrintWriter.flush();

        return causeValuesStringWriter.toString();
    }
}
