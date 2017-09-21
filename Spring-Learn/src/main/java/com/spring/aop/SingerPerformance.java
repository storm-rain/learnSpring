package com.spring.aop;

import org.springframework.stereotype.Component;

@Component("singerPerformance")
public class SingerPerformance implements Performance
{
    public void perform()
    {
        System.out.println("Singing a nice song");
       // throw new RuntimeException();
    }
}
