package com.fha.nf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class NetworkFallaciesConfiguration {
  @Bean
  public NetworkFailureAspect networkFailureAspect() {
    return new NetworkFailureAspect();
  }
}
