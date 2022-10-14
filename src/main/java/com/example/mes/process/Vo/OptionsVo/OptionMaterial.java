package com.example.mes.process.Vo.OptionsVo;

import java.io.Serializable;
import java.util.ArrayList;

public class OptionMaterial implements Serializable {
    String name;
    ArrayList<OptionSize> optionSizes;

    public OptionMaterial(String name, ArrayList<OptionSize> optionSizes) {
        this.name = name;
        this.optionSizes = optionSizes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<OptionSize> getOptionSizes() {
        return optionSizes;
    }

    public void setOptionSizes(ArrayList<OptionSize> optionSizes) {
        this.optionSizes = optionSizes;
    }

    @Override
    public String toString() {
        String str = "[";
        int len = optionSizes.size();
        for(OptionSize optionSize:optionSizes){
            str+=optionSize.toString();
            if(len-->1){
                str+=",";
            }
        }
        str+="]";
        return "{\"value\":\""+name+"\",\"label\":\""+name+"\",\"children\":"+str+"}";
    }
}
