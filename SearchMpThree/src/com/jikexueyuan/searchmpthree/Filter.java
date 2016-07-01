package com.jikexueyuan.searchmpthree;

import java.io.File;

public class Filter {//搜索类

    private static void getMpThree(File folder) {
        if (folder != null) {
            File[] files = folder.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getAbsolutePath().toLowerCase().endsWith(".mp3")) {
                        System.out.println(file.getAbsoluteFile());
                    }
                } else if (file.isDirectory()) {
                    getMpThree(file);   //递归调用该函数
                }
            }
        }
    }

    public static void main(String args[]) {//测试
        //用户在匿名对象中输入过滤目录
        File folder = new File(new File("mp3").getAbsoluteFile().getParent());//搜索该项目根目录下的mp3目录内的扩展名为mp3的文件
        getMpThree(folder);//过滤出mp3文件
    }

}
