package com.jvirriel.testrestful.backend;

import com.jvirriel.testrestful.backend.configuration.SwaggerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories("com.jvirriel.testrestful.backend")
@EnableScheduling
@EntityScan("com.jvirriel.testrestful.model")
@ComponentScan({"com.jvirriel.testrestful.backend"})
@Import({SwaggerConfig.class})
@PropertySources({
        @PropertySource("file:C:\\home\\produccion\\conf\\apps\\testrestful\\be\\application.properties"),
        @PropertySource("file:C:\\home\\produccion\\conf\\apps\\testrestful\\be\\config.properties")
})
public class BackendApp  extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(BackendApp.class);

    public static void main(String[] args){
        logger.warn("*** main ***");
        SpringApplication.run(BackendApp.class, args);
    }

}