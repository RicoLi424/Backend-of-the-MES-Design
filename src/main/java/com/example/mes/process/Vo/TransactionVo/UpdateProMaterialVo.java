package com.example.mes.process.Vo.TransactionVo;

public class UpdateProMaterialVo {

    String name;
    String size;

    String count;

    public UpdateProMaterialVo() {
    }

    public UpdateProMaterialVo(String name, String size, String count) {
        this.name = name;
        this.size = size;

        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "UpdateProMaterialVo{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
