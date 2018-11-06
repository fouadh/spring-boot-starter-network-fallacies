package com.fha.nf;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(NetworkFallaciesConfiguration.class)
public @interface EnableNetworkFallacies {
}
