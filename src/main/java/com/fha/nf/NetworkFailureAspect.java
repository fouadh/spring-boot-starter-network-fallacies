package com.fha.nf;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
@Aspect
public class NetworkFailureAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(NetworkFailureAspect.class);

    public NetworkFailureAspect() {
        LOGGER.info("------------------------- INIT NetworkFailureAspect");
    }

    @Around("@annotation(networkFailure)")
    public Object detectNetworkFailure(ProceedingJoinPoint joinPoint, NetworkFailure networkFailure) throws Throwable {
        LOGGER.info(">>>>>>>> Running dices: 1 odd on " + networkFailure.odds());
        boolean trigger = ThreadLocalRandom.current().nextInt(networkFailure.odds()) == 0;
        if (trigger)
            throw new NetworkFailureException("Request Network Failure in " + joinPoint.getSignature().toLongString());

        Object proceed = joinPoint.proceed();

        trigger = ThreadLocalRandom.current().nextInt(2) == 0;
        if (trigger)
            throw new NetworkFailureException("Response Network Failure in "  + joinPoint.getSignature().toLongString());

        return proceed;
    }
}
