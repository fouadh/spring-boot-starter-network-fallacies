package com.fha.nf.sample;

import com.fha.nf.EnableNetworkFallacies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableNetworkFallacies
public class SpringAmqpApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringAmqpApplication.class, args);
  }
}
