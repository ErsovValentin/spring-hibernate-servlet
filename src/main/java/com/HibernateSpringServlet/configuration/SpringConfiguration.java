package com.HibernateSpringServlet.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



@Configuration
@Import(HibernateConfiguration.class)
@ComponentScan({"com.HibernateSpringServlet.DAO"})
public class SpringConfiguration {
}
