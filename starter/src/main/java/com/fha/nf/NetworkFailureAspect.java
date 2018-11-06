package com.fha.nf;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.concurrent.ThreadLocalRandom;

@Aspect
public class NetworkFailureAspect {
  @Around("@annotation(networkFailure)")
  public Object detectNetworkFailure(ProceedingJoinPoint joinPoint, NetworkFailure networkFailure) throws Throwable {
    failEventually(joinPoint, networkFailure, "Request");
    Object proceed = joinPoint.proceed();
    failEventually(joinPoint, networkFailure, "Response");
    return proceed;
  }

  private void failEventually(ProceedingJoinPoint joinPoint, NetworkFailure networkFailure, final String event) {
    boolean trigger = ThreadLocalRandom.current().nextInt(networkFailure.odds()) == 0;
    if (trigger)
      throw new NetworkFailureException(event + " Network Failure in " + joinPoint.getSignature().toLongString());
  }
}
