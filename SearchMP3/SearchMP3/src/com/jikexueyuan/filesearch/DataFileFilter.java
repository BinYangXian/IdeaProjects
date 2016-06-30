package com.jikexueyuan.filesearch;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by yangx on 2015/12/26.
 */
public class DataFileFilter implements FilenameFilter {  //FilenameFilter测试指定文件是否应该包含在某一文件列表中

    private String extension;

    DataFileFilter(String _extension) {
        this.extension = _extension;
    }

    public boolean accept(File directory, String filname) {
        // TODO Auto-generated method stub
        return filname.endsWith(extension);   //测试此字符串是否以指定的后缀结束。
    }

}
