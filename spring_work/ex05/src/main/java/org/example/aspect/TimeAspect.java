package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Aspect;

import java.time.Duration;
import java.time.LocalTime;

@Aspect
public class TimeAspect {

    // spring security

    // springboot 인터셉터 필터..

    @Pointcut("execution(* org.example.components..*(..))")
    private void publicTarget() {
    }

//    @Around("execution(* org.example..*(..))")
//    @Around("@annotation(As)")
    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("시작하기 전에 실행되는 부분");
        LocalTime beforeTime = LocalTime.now();
        try {
            System.out.println("되나");
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            LocalTime afterTime = LocalTime.now();
            Duration duration =  Duration.between(beforeTime,afterTime);
            System.out.println(duration.getNano());
            System.out.println("끝나기전에 실행되는 부분");

        }


    }

}
