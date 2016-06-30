package com.wangyi.clock;

import java.util.ArrayList;

/**
 * Created by fangc on 2016/1/20.
 */
public class DataBase {
//    private ArrayList<CD> listCD=new ArrayList<CD>();
    private ArrayList<Item> listItem=new ArrayList<Item>();
//    public void add(CD cd){
//        listCD.add(cd);
//    }
    public void add(Item items){
        listItem.add(items);
    }
    public void list(){
        for (Item item :
                listItem) {
            item.print();
        }
    }

//    public void list(){
//        for (CD cd :listCD) {
//            cd.print();
//        }
//    }

}
