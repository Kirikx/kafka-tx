package ru.devstend.kafkaproducer.config;

import javax.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;

@Configuration
public class AppConfig {

  // Kafka transactional
//  @Bean
//  @Primary
//  public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//    return new JpaTransactionManager(entityManagerFactory);
//  }

}
