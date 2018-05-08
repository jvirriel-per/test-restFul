package com.jvirriel.testrestful.backend.configuration;

//import org.apache.ignite.Ignite;
//import org.apache.ignite.IgniteCache;
//import org.apache.ignite.Ignition;
//import org.apache.ignite.cache.CacheMode;
//import org.apache.ignite.configuration.CacheConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ApacheIgniteCacheConfig {
//
//    String CACHE_NAME = "MyCache";
//
//    @Bean
//    public Ignite igniteConfig() {
//
//        Ignite ignite = Ignition.start("C:\\sources\\workspaces\\TEST2\\restapi\\src\\main\\resources\\ignite-cache-config.xml");
//        CacheConfiguration<Integer, String> cfg = new CacheConfiguration<>();
//
//        cfg.setCacheMode(CacheMode.PARTITIONED);
//        cfg.setName(CACHE_NAME);
//
//        IgniteCache<Integer, String> cache = ignite.getOrCreateCache(cfg);
//        return ignite;
//
//
//    }
//}
