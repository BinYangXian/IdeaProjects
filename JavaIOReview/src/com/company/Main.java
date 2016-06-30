package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//通过创建一个data.txt文件来存储数据，然后进行读写操作复习
public class Main {

    public static void main(String[] args) {
        File file=new File("data.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
                FileOutputStream fileOutputStream=new FileOutputStream(file);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
