package com.example.mes.process.Service;

import com.example.mes.process.Vo.EquipmentVo.*;
import com.example.mes.process.Vo.MaterialVo.TemplateMaterialVo;
import com.example.mes.process.Vo.PageVo.PageVo;

import java.util.List;

public interface IEquipmentService {

    List<TemplateEquipmentVo> getTemplateEquipments(String company_id);

    List<TemplateEquipmentVo> getTemplateEquipmentByID(String company_id, String equipment_id);

    String addTemplateEquipmentVo(TemplateEquipmentVo templateEquipmentVo);

    String deleteTemplateEquipmentByName(TemplateEquipmentVo templateEquipmentVo);

    String updateEquipment(TemplateEquipmentVo templateEquipmentVo);

    List<QueryEquipmentVo> getEquipments(PageVo pageVo,int company_id);

    QueryEquipmentVo getEquipmentByID(String equipment_id,int company_id);

    String addEquipment(InsertEquipmentVo insertEquipmentVo);

    String deleteEquipmentByID(DeleteEquipmentVo deleteEquipmentVo);

    String updateEquipmentByID(UpdateEquipmentVo updateEquipmentVo);

    int getCount();

    int getIndex();

    List<QueryEquipmentVo> getEquipmentByName(String name,String company_id);
}
