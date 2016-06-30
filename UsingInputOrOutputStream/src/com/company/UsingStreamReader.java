package com.company;

import java.io.*;

/**
 * Created by fangc on 2016/4/15.
 */
//通过字符流形式读取数据
public class UsingStreamReader {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");

            char[] chars = new char[50];
            String str = "";
            int i;
            while ((i = inputStreamReader.read(chars)) != -1) {
                str += new String(chars,0,i);//参数2、偏移量（从第几个字符开始算起）；3、总共读取字符数
            }
            System.out.println(str);
            inputStreamReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
