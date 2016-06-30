package com.wangyi.clock;

/**
 * Created by fangc on 2016/1/20.
 */
public  class Item {
    private String title;
   private  String comment;
    private int playingTime;
    private boolean gotIt;

    public Item(int playingTime, String title, String comment, boolean gotIt) {
        this.playingTime = playingTime;
        this.title = title;
        this.comment = comment;
        this.gotIt = gotIt;
    }

    public void print(){
        System.out.println(title+comment+playingTime+gotIt);
    }
}
