package com.example.mes.process.Mapper;

import com.example.mes.process.Entity.TemplateEquipment;
import com.example.mes.process.Entity.TemplateMaterial;
import com.example.mes.process.Vo.EquipmentVo.*;
import com.example.mes.process.Vo.PageVo.PageVo;
import com.example.mes.template.entity.EquipmentTemplate;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EquipmentMapper {

    @Select("select * from template_equipment where ( company_id = #{company_id} )")
    List<TemplateEquipment> getTemplateEquipments(@Param("company_id")String company_id);
    @Select("select * from template_equipment where  company_id = #{company_id}  and equipment_id = #{equipment_id} ")
    List<TemplateEquipment> getTemplateEquipmentsByID(@Param("company_id")String company_id,@Param("equipment_id") String equipment_id);

    @Insert("insert into template_equipment(equipment_id, name , attribute, attribute_value, company_id) values ( #{equipment_id} , #{name} ,#{attribute},#{attribute_value},#{company_id})")
    Integer addTemplateEquipment(TemplateEquipment templateEquipment);

    @Delete("delete from template_equipment where name=#{name}  and (company_id = #{company_id} or #{company_id}=0 )")
    int deleteTemplateEquipmentByName(@Param("name") String name,@Param("company_id") String company_id);

    List<QueryEquipmentVo> getEquipments(@Param("pageVo") PageVo pageVo,@Param("company_id") int company_id);

    QueryEquipmentVo getEquipmentByID(@Param("equipment_id") String equipment_id,@Param("company_id") int company_id);

    boolean addEquipment(@Param("insertEquipmentVo") InsertEquipmentVo insertEquipmentVo);

    boolean deleteEquipmentByID(@Param("deleteEquipmentVo") DeleteEquipmentVo deleteEquipmentVo);

    boolean updateEquipmentByID(@Param("updateEquipmentVo") UpdateEquipmentVo updateEquipmentVo);

    int getCount();

    int checkDuplicate(@Param("name") String name,@Param("purpose") String purpose,@Param("company_id") int company_id);

    int getIndex();


    List<QueryEquipmentVo> getEquipmentByName(@Param("name")String name,@Param("company_id") String company_id);
}
