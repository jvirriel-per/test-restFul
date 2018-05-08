package com.jvirriel.testrestful.backend.bus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

public class PeriodicTask {
    private volatile boolean running = true;
    private volatile int interval = 5;
    private final Object lockObj = new Object();

    @Autowired
    private Receiver receiver;
    //private Listener listener;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void startTask() throws InterruptedException {
        while (running) {
            doTasks();
            synchronized (lockObj) {
                try {
                    lockObj.wait(interval * 1000);
                } catch (InterruptedException e) {
                    //Handle Exception
                }
            }
        }
    }

    public void stopTask() {
        this.running = false;
    }

    public void setInterval(int newInterval) {
        synchronized (lockObj) {
            this.interval = newInterval;
            lockObj.notify();
        }
    }

    private void doTasks() throws InterruptedException {
//        logger.info(" *** Tarea Periodica " + "[" + Thread.currentThread().getName()
//                + "] Interval: " + interval);

        if (receiver != null && receiver.getLatch() != null) receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);


    }
}
