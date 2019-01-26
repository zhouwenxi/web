package com.qishui.utils;

/**
 * Created by zhou on 2019/1/26.
 *
 */
public class LogUtils {

    private static Boolean flag = true;
    private static String TAG = "Qihui";

    /**
     * 打印日志
     *
     * @param message
     */
    public static void e(Object message) {

        if (flag) {
            System.out.println(TAG + ": " + message);
        }
    }
}
