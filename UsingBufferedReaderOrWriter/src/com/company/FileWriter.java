package com.company;

import java.io.*;

/**
 * Created by fangc on 2016/4/15.
 */
public class FileWriter {
    //练习之文件的简单读写：字符流读/写缓冲区的读/写练习，并在控制台中输出显示
    public static void main(String[] args) {

        try {
            FileOutputStream fileOutputStream=new FileOutputStream("src/hello.txt");
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);

                bufferedWriter.write("我爱即可学院，我不是单身abc123");
            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
