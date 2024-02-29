package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.aspectj.lang.annotation.Aspect;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Aspect
public class TimeAspect {

    @Pointcut("execution(public * org.example.components..*(..))")
    private void publicTarget() {
    }

    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LocalTime beforeTime = LocalTime.now();
        try {
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            LocalTime afterTime = LocalTime.now();
            Duration duration =  Duration.between(beforeTime,afterTime);
            System.out.println(duration.getNano());
        }

    }

}
