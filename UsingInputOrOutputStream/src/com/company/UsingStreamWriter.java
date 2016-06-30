package com.company;

import java.io.*;

/**
 * Created by fangc on 2016/4/15.
 */
//通过字符流形势写入数据
public class UsingStreamWriter {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");

            FileOutputStream fileOutputStream = new FileOutputStream("newFile.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");

            char[] chars = new char[50];
            int i;
            while ((i = inputStreamReader.read(chars)) != -1) {
                outputStreamWriter.write(chars,0,i);//参数2、偏移量（从第几个字符开始算起）；3、总共写入字符数
            }
            outputStreamWriter.close();
            fileOutputStream.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

