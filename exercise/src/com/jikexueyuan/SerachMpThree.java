package com.jikexueyuan;

import java.io.File;

public class SerachMpThree {//搜索类

    private static void getMpThree(File folder) {
        int countFileNum=0;
        if (folder != null) {
            File[] files = folder.listFiles();
            if (files!=null){ //当在windows系统中，Win下有好些目录是没有列表权限的，因为其是目录链接
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.getName().equals("UisingSqlite")) {
                            System.out.println(file.getAbsoluteFile());
                        }
                    } else if (file.isDirectory()) {
                        if (file.getName().equals("UisingSqlite")) {
                            System.out.println(file.getAbsoluteFile());
                        }
                        System.out.println(++countFileNum);
                        getMpThree(file);   //递归调用该函数
                    }
                }
            }
        }
    }

    public static void main(String args[]) {//测试
        //用户在匿名对象中输入过滤目录
        File folder = new File("c:/Users/fangc/");//搜索该项目根目录下的mp3目录内的扩展名为mp3的文件
        getMpThree(folder);//过滤出mp3文件
    }

}