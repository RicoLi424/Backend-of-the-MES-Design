package com.example.mes.process.Service;

import com.example.mes.process.Vo.MaterialVo.*;
import com.example.mes.process.Vo.PageVo.PageVo;

import java.util.List;

public interface IMaterialService {
    //从物料表material中查询全部物料信息
    List<TemplateMaterialVo> getTemplateMaterials(String company_id);

    //跟据物料id查询对应物料的信息
    List<TemplateMaterialVo> getTemplateMaterialByID(String company_id,String material_id);

    String addTemplateMaterialVo(TemplateMaterialVo templateMaterialVo);

    String deleteTemplateMaterialByName(TemplateMaterialVo templateMaterialVo);

    String updateMaterial(TemplateMaterialVo templateMaterialVo);

    List<QueryMaterialVo> getMaterials(PageVo pageVo,Integer company_id);
    //跟据物料id查询对应物料的信息
    QueryMaterialVo getMaterialByID(String material_id ,int company_id);
    //增加一个物料
    String addMaterial(InsertMaterialVo insertMaterialVo);
    //根据物料id删除一个物料
    String deleteMaterialByID(DeleteMaterialVo deleteMaterialVo);
    //修改一个物料，status与comments
    String updateMaterialByID(UpdateMaterialVo updateMaterialVo);
    List<QueryMaterialVo> getMaterialByName(String name,String company_id);

    int getCount();

    int getIndex();



}
