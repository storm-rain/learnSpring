package com.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AopConfig
{
    @Bean("musicPerformance")
    public Performance musicPerormance()
    {
        return new MusicPerformance();
    }
    @Bean("audience")
    public Audience audience()
    {
        return new Audience();
    }

    @Bean("huaweiPlayer")
    public HuaweiPlayer getHuaweiPlayer()
    {
        List<String> tracks = new ArrayList<String>();
        tracks.add("a");
        tracks.add("b");
        tracks.add("c");
        tracks.add("d");

        return new HuaweiPlayer(tracks);
    }

    @Bean("trackCounter")
    public TrackCounter getTrackCounter()
    {
        return new TrackCounter();
    }

    @Bean
    public EncoreableIntroducer getEncoreableIntroducer()
    {
        return new EncoreableIntroducer();
    }

}
