package com.example.mes.system.service.impl;

import java.sql.Timestamp;

public class MyImplUtils {
    public static int getNumStart(int pageNum, int pageSize) {
        int numStart = (pageNum - 1) * pageSize;
        return numStart;
    }

    public static int getNumEnd(int pageSize) {
        int numEnd = pageSize;
        return numEnd;
    }

    public static Timestamp getCurrentTime() {
        return new Timestamp(System.currentTimeMillis());
    }

}
