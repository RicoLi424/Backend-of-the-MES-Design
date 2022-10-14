package com.example.mes.process.Vo.OptionsVo;

import java.util.ArrayList;

public class OptionSize {
    String size;

    public OptionSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }



    @Override
    public String toString() {

        size=size.replace("\"", "");
        size=size.replace("{", "");
        size=size.replace("}", "");


        return "{\"value\":\""+size+"\",\"label\":\""+size+"\""+"}";
    }
}
