
package com.company;
import java.io.File;
import java.io.FilenameFilter;

/**
 * *该类主要是过滤得到指定后缀名的文件
 **/
public class DataFileFilter implements FilenameFilter {

    String extension;

    DataFileFilter(String extension) {//在新建该类的对象时，用指定字符串初始化扩展名
        this.extension = extension;
    }

    public boolean accept(File directory, String filname) {
        // TODO Auto-generated method stub
        return filname.endsWith(extension);
    }

}