package com.example.mes.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyUtils {
    public static void success(HashMap<String, Object> res) {
        res.put("code", 200);
        res.put("message", "success");
    }

    public static void fail(HashMap<String, Object> res, String message) {
        res.put("code", -1);
        res.put("message", message);
    }

    public static List<String> removal(List<String> oldList, List<String> newList) {
        List<String> list = new ArrayList<>();
        for (String accessName2 : newList) {
            boolean isExits = false;
            for (String accessName1 : oldList) {
                if (accessName2.equals(accessName1)) {
                    isExits = true;
                    break;
                }
            }
            if (!isExits) {
                list.add(accessName2);
            }
        }
        return list;
    }

    public static void successMsg(HashMap<String, Object> res, String message) {
        res.put("code", 100);
        res.put("message", message);
    }
}