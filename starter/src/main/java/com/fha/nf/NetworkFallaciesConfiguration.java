package com.fha.nf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
public class NetworkFallaciesConfiguration {
  @Bean
  public NetworkFailureAspect networkFailureAspect() {
    return new NetworkFailureAspect();
  }
}
