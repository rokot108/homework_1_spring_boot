package ru.volkov.homework_1_spring_boot.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ConsoleLogging {

    @Pointcut("execution(* ru.volkov.homework_1_spring_boot.services.UserServiceImpl.*(..))")
    public void userServiceActions() {
    }

    @Before("userServiceActions()")
    public void serviceMethodCalled(JoinPoint joinPoint) {
        System.out.println("User service method called: " + joinPoint.getSignature());
    }

}
