package com.wangyi.clock;

/**
 * Created by fangc on 2016/1/20.
 */
public class VideoGame extends Item{
   private int numberOfPlays;

    public VideoGame(int playingTime, String title, String comment, boolean gotIt, int numberOfPlays) {
        super(playingTime, title, comment, gotIt);
        this.numberOfPlays = numberOfPlays;
    }

    @Override
    public void print() {
        super.print();
    }
}
