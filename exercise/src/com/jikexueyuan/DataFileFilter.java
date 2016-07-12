package com.jikexueyuan;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fangc on 2016/7/1.
 */
public class DataFileFilter implements FilenameFilter {

    private String filetypes;

    private DataFileFilter(String filetypes) {//在新建该类的对象时，用指定字符串初始化扩展名
        this.filetypes = filetypes;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(filetypes);
    }

    public static void main(String args[]) {

        File folder = new File("f:/");//要进行过滤的文件目录

//        List<String> allfilename = new ArrayList<String>();//存储所有符合条件的文件名

        String filetypes = "mp3";//过滤文件类型
        DataFileFilter filter = new DataFileFilter(filetypes);
        String[] filenames = folder.list(filter);
//        allfilename.addAll(Arrays.asList(filenames));
        for (String i : filenames
                ) {
            System.out.println(i);
        }
    }
}
