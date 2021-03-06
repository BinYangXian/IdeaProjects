package com.jikexueyuan.nio.ioexample;

import java.io.*;

/**
 * Created by fangc on 2016/5/22.
 */
public class IOExample {

    public static void main(String[] args) throws IOException {
        //Write
        File file = new File("data.txt");
        if (!file.exists()) {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write("love you".getBytes("utf-8"));
            fileOutputStream.close();
        }
        //Read 方法2
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line).append("\n");
            }
            System.out.println(buffer);
            bufferedReader.close();
            fileInputStream.close();
        }
    }
}
