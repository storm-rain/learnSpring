package com.spring.aop;

import java.util.List;

public class HuaweiPlayer
{
    List<String> tracks;

    public HuaweiPlayer(List<String> tracks)
    {
        this.tracks = tracks;
    }

    public void playTrack(int i)
    {
        System.out.println(tracks.get(i-1));
    }
}
