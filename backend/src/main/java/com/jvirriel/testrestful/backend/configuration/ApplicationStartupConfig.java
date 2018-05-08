package com.jvirriel.testrestful.backend.configuration;


import com.jvirriel.testrestful.backend.bus.PeriodicTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component
@ComponentScan("com.credix.batchprocessor.model")
public class ApplicationStartupConfig implements ApplicationListener<ApplicationReadyEvent> {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        logger.info("*** onApplicationEvent ***  ");

        final PeriodicTask task = new PeriodicTask();
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()
                    + " starting");
            try {
                task.startTask();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()
                    + " done with the periodic task");
        });
        t.start();
        try {
            sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.setInterval(1);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
