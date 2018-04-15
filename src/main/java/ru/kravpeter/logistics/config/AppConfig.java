package ru.kravpeter.logistics.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "ru.kravpeter.logistics")
@Import(value = {WebConfig.class, PersistenceConfig.class, SecurityConfig.class})
public class AppConfig {


}