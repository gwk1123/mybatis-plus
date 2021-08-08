package com.mybatis.plus.utils;


import com.baomidou.mybatisplus.core.toolkit.SystemClock;

public class CreateOrderNo {

    private static final String HEAD = "GN";
    private static Integer LENGTH = 4;
    private static Integer todayOrderNumber = 0;

    public CreateOrderNo() {
    }

    public static String create() {
        String timeStamp = SystemClock.now() + "";
        StringBuffer numStr = new StringBuffer();
        synchronized(todayOrderNumber) {
            if ((todayOrderNumber + 1 + "").length() > LENGTH) {
                todayOrderNumber = 0;
            }

            numStr.append((todayOrderNumber = todayOrderNumber + 1) + "");
        }

        Integer length = numStr.toString().length();

        for(int i = 0; i < LENGTH - length; ++i) {
            numStr.insert(0, "0");
        }

        return HEAD + timeStamp + numStr;
    }


}
