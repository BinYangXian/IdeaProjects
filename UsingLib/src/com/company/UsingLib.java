package com.company;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class UsingLib {

    public static void main(String[] args) {
        //1、文件拷贝，只需一句命令：
//        File srcFile=new File("src/test.txt");
//        File copyFile=new File("copyFile.txt");
//        try {
//            FileUtils.copyFile(srcFile,copyFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //2、直接写入文件
        File file=new File("copyFile.txt");
        try {
            FileUtils.write(file,"我爱我家");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
