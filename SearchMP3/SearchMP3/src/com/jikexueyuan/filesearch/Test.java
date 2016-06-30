package com.jikexueyuan.filesearch;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangx on 2015/12/26.
 */
public class Test {

    public static void main(String args[]) {

        File folder = new File("yanzi/"); //要进行过滤的文件目录

        List<String> allFileNames = new ArrayList<String>();

        String fileTypes = "mp3";
        DataFileFilter filter = new DataFileFilter(fileTypes);
        String[] fileNames = folder.list(filter); //返回一个字符串数组，
        // 这些字符串指定此抽象路径名表示的目录中的文件和目录。
        allFileNames.addAll(Arrays.asList(fileNames));/*按照指定 collection 的迭代器所返回的元素顺序，
        将该 collection 中的所有元素添加到此列表的尾部。返回一个受指定数组支持的固定大小的列表。*/
        for (String i : allFileNames
                ) {
            System.out.println(i);
        }

    }


}
