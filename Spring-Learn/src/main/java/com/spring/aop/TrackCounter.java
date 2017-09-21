package com.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class TrackCounter
{
    private Map<Integer, Integer> trackedMap = new HashMap<Integer, Integer>();

    @Pointcut("execution(* com.spring.aop.HuaweiPlayer.playTrack(int)) && args(trackNumber)")
    public void trackPlayed(int trackNumber)
    {
    }

    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber)
    {
        int num = getTrackNumber(trackNumber);
        trackedMap.put(trackNumber, ++num);
    }

    public int getTrackNumber(int trackNumber)
    {
        return trackedMap.containsKey(trackNumber) ? trackedMap.get(trackNumber) : 0;
    }

}
