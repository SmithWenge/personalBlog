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
            if(!".bash_profile".equals(fileName.getName()) && !".bash_logout".equals(fileName.getName()) && !".bashrc".equals(fileName.getName())) {
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
            if(!".bash_profile".equals(fileName.getName()) && !".bash_logout".equals(fileName.getName()) && !".bashrc".equals(fileName.getName())) {
                list.add(String.valueOf(((fileName.length())/1024))+"kb");
            }
        }

        return list;
    }
}
