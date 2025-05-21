package practice.Aspect_Oriented_Programming_Practice;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* practice.Aspect_Oriented_Programming_Practice.MyService.serve(..))")
    public void beforeServe() {
        System.out.println("🔍 Before method serve()");
    }

    @After("execution(* practice.Aspect_Oriented_Programming_Practice.MyService.serve(..))")
    public void afterServe() {
        System.out.println("✅ After method serve()");
    }

    @AfterReturning("execution(* practice.Aspect_Oriented_Programming_Practice.serve(..))")
    public void afterReturnServe() {
        System.out.println("🎉 Method returned successfully");
    }

    @AfterThrowing("execution(* practice.Aspect_Oriented_Programming_Practice.MyService.riskyMethod(..))")
    public void afterThrowing() {
        System.out.println("💥 Exception was thrown");
    }

    @Around("execution(* practice.Aspect_Oriented_Programming_Practice.MyService.serve(..))")
    public Object aroundServe(org.aspectj.lang.ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("🕓 Before proceed()");
        Object result = pjp.proceed();  // execute original method
        System.out.println("🕓 After proceed()");
        return result;
    }
}
