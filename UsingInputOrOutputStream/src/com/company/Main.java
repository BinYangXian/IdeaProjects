package com.company;

import java.io.*;
//通过字节流的读写实现文件拷贝
public class Main {

    public static void main(String[] args) {
        File file=new File("src/newIma.png");

        try {
            file.createNewFile();
            FileInputStream fileInputStream=new FileInputStream("src/ima.png");
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            byte[] bytes=new byte[30];//此参数不宜过大

            while (fileInputStream.read(bytes)!=-1){
                fileOutputStream.write(bytes);
            }

            fileOutputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
