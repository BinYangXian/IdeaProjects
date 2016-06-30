package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2015/12/26.
 */
public class Test {

    public static void main(String args[]) {

        File folder = new File("f:/");//要进行过滤的文件目录

//        List<String> allfilename = new ArrayList<String>();//存储所有符合条件的文件名

        String Filetypes = "mp3";//过滤文件类型
        DataFileFilter filter = new DataFileFilter(Filetypes);
        String[] filenames = folder.list(filter);
//        allfilename.addAll(Arrays.asList(filenames));
            System.out.println(filenames);


//        String[] Filetypes1 = {"sql","dmp"};
//        DataFileFilter filter1 = null;
//        for(int i=0;i<Filetypes1.length;i++){
//            filter = new DataFileFilter(Filetypes1[i]);
//            String[] filenames1 = folder.list(filter);
//            allfilename.addAll(Arrays.asList(filenames));
//        }
    }
}