package com.wangyi.clock;

public class Main {

    public static void main(String[] args) {
        DataBase db=new DataBase();
        db.add(new CD(60,"说爱你","...",true,4,"蔡依林"));//int playingTime, String title, String comment, boolean gotIt, int numofTracks, String artist
        db.add(new CD(60,"屋顶","...",true,5,"侯佩岑"));
        db.list();

    }
}
