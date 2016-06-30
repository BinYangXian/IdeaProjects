package com.wangyi.clock;

/**
 * Created by fangc on 2016/1/20.
 */
public class CD extends Item{
    private int numofTracks;
    private String artist;

    public CD(int playingTime, String title, String comment, boolean gotIt, int numofTracks, String artist) {
        super(playingTime, title, comment, gotIt);
        this.numofTracks = numofTracks;
        this.artist = artist;
    }

    public void print() {
        System.out.println("CD:");
        super.print();
        System.out.println(numofTracks+artist);
    }
}
