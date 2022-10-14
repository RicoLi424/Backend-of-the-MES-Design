package com.example.mes.process.Vo.TransactionVo;

import com.example.mes.process.Vo.MaterialVo.QueryProMaterialVo;
import com.example.mes.process.Vo.ProductVo.QueryProductVo;

import java.util.ArrayList;
import java.util.HashMap;

public class QueryVo {

    //产品信息
    QueryProductVo product;
    //工艺路线
    HashMap<String,Object> process;
    //
    ArrayList<QueryProMaterialVo> material;

    public QueryVo() {
    }

    public QueryVo(QueryProductVo product, HashMap<String, Object> process, ArrayList<QueryProMaterialVo> material) {
        this.product = product;
        this.process = process;
        this.material = material;
    }

    public QueryProductVo getProduct() {
        return product;
    }

    public void setProduct(QueryProductVo product) {
        this.product = product;
    }

    public HashMap<String, Object> getProcess() {
        return process;
    }

    public void setProcess(HashMap<String, Object> process) {
        this.process = process;
    }

    public ArrayList<QueryProMaterialVo> getMaterial() {
        return material;
    }

    public void setMaterial(ArrayList<QueryProMaterialVo> material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "product=" + product +
                ", process=" + process +
                ", material=" + material +
                '}';
    }
}
