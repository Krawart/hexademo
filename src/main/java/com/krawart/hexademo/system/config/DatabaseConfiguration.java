package com.krawart.hexademo.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories({"com.krawart.hexademo"})
@EnableTransactionManagement
public class DatabaseConfiguration {}
