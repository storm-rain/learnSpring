package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience
{
    @Pointcut("execution(* com.spring.aop.Performance.perform(..))")
    public void performance(){}

    @Before("performance()")
    public void silenceCellphones()
    {
        System.out.println("silencing cell phones");
    }

    @Before("performance()")
    public void takeSeats()
    {
        System.out.println("Taking seats");
    }

    @AfterReturning("performance()")
    public void applause()
    {
        System.out.println("CLAP!  CLAP!!");
    }

    @AfterThrowing("performance()")
    public void demandRefund()
    {
        System.out.println("demanding a refund");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp)
    {
        try
        {
            System.out.println("Scilencing cell phones");
            System.out.println("Taking a seat");
            jp.proceed();
            System.out.println("Clap ,Clap!");

        }
        catch (Throwable t)
        {
            System.out.println("Oh,has exception!");
        }
    }
}
