package com.sullivan.blog.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sullivan on 2017/7/10.
 */
public class FileUtil {

    public static List<String> getAbsolutePaths(String pathName) {
        List<String> list = new ArrayList<>();
        File file = new File(pathName);
        File[] files = file.listFiles();

        for(File fileName : files) {
            // 除去隐藏文件
            if(!fileName.getName().startsWith(".")) {
                list.add(fileName.getAbsolutePath());
            }
        }

        return list;
    }

    public static List<String> getLengths(String pathName) {
        List<String> list = new ArrayList<>();
        File file = new File(pathName);
        File[] files = file.listFiles();

        for(File fileName : files) {
            // 除去隐藏文件
            if(!fileName.getName().startsWith(".")) {
                list.add(String.valueOf(((fileName.length())/1024))+"kb");
            }
        }

        return list;
    }
}
