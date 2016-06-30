package com.company;

import java.io.*;

public class FileReader {

//练习之文件的简单读写：字符流读/写缓冲区的读/写练习，并在控制台中输出显示
    public static void main(String[] args) {
        File file=new File("src/hello.txt");
        try {
            if (!file.exists())
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStream=new FileInputStream("src/test.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

            String str=null;
            while ((str=bufferedReader.readLine())!=null){
                System.out.println(str);
            }

            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
