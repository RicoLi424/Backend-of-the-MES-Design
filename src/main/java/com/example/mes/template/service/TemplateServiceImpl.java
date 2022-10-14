package com.example.mes.template.service;

import com.example.mes.process.Vo.MaterialVo.DeleteMaterialVo;
import com.example.mes.process.Vo.MaterialVo.InsertMaterialVo;
import com.example.mes.process.Vo.MaterialVo.QueryMaterialVo;
import com.example.mes.process.Vo.MaterialVo.UpdateMaterialVo;
import com.example.mes.template.entity.EquipmentTemplate;
import com.example.mes.template.entity.MaterialTemplate;
import com.example.mes.template.vo.EquipmentTemplateVO;
import com.example.mes.template.vo.MaterialTemplateVo;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface TemplateServiceImpl {
        List<MaterialTemplateVo> getAllMaterial(String company_id);
        List<MaterialTemplateVo> getMaterialTemplateByName(String name,String company_id);
        //跟据物料模板id查询对应物料的信息
        List<MaterialTemplate> getMaterialTemplateByID(int material_id,String company_id);
        //增加一个物料模板
        String addMaterialTemplate(MaterialTemplateVo materialTemplateVo);
        //根据物料模板id删除一个物料
        String deleteMaterialTemplate(MaterialTemplateVo materialTemplateVo);
        //修改一个物料模板
        String updateMaterialTemplate(MaterialTemplateVo materialTemplateVo);



        public List<EquipmentTemplateVO> getEquipmentTemplateByID(int equipment_id,String company_id);

        public List<EquipmentTemplateVO> getEquipmentTemplateByName(String name,String company_id);

        public List<EquipmentTemplateVO> getAllEquipment(String company_id);

        String addEquipmentTemplate(EquipmentTemplateVO equipmentTemplateVO);

        String deleteEquipmentTemplate(EquipmentTemplateVO equipmentTemplateVO);

        String updateEquipmentTemplate(EquipmentTemplateVO equipmentTemplateVO);


}
