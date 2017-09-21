package com.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer
{
    @DeclareParents(value = "com.spring.aop.Performance+",defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
