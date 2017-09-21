package com.spring.aop;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class TestAop
{
    @Test
    public void testAop()
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);

        Assert.assertNotNull(ctx.getBean("audience"));
        Assert.assertNotNull(ctx.getBean("singerPerformance"));
        Assert.assertNotNull(ctx.getBean("musicPerformance"));

        Performance p = (Performance) ctx.getBean("singerPerformance");
        p.perform();

        Encoreable encoreable = (Encoreable) ctx.getBean("singerPerformance");
        encoreable.performEncore();

        System.out.println("###################");
        Performance musicP = (Performance) ctx.getBean("musicPerformance");
        musicP.perform();

        HuaweiPlayer player = (HuaweiPlayer) ctx.getBean("huaweiPlayer");
        player.playTrack(1);
        player.playTrack(3);
        player.playTrack(2);
        player.playTrack(1);
        player.playTrack(4);
        player.playTrack(3);
        player.playTrack(3);

        TrackCounter counter = (TrackCounter) ctx.getBean("trackCounter");
        Assert.assertEquals(2, counter.getTrackNumber(1));
        Assert.assertEquals(1, counter.getTrackNumber(2));
        Assert.assertEquals(3, counter.getTrackNumber(3));
        Assert.assertEquals(1, counter.getTrackNumber(4));
    }
}
