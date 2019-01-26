package com.qishui.utils;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhou on 2019/1/26.
 *
 */
public class FileUtils {

    /**
     * 自动寻找盘符,生成目录及文件
     *
     * @param dir  pic
     * @param name
     * @return
     */
    public static String getDir(String dir, String name) {

        for (int i = 90; i >= 67; i--) {
            char ch = (char) i;
            LogUtils.e("遍历:" + (char) i + "--> " + i);
            if (new File(String.valueOf(ch) + ":").exists()) {
                File parent = new File(ch + ":/" + dir);
                if (!parent.exists()) {
                    parent.mkdirs();
                }
                File file = new File(parent, name);
                if (file.exists()) {
                    file.delete();
                }
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
                LogUtils.e("生成路径:" + file.getAbsolutePath());
                return file.getAbsolutePath();
            }
        }
        throw new RuntimeException();
    }

}
