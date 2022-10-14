package com.example.mes.template.mapper;
import com.example.mes.template.entity.EquipmentTemplate;
import com.example.mes.template.entity.MaterialTemplate;
import org.apache.ibatis.annotations.*;


import java.util.List;
@Mapper
public interface TemplateMapper {

    @Select("select * from material_template where ( company_id = #{company_id} or #{company_id}=0 )")
    List<MaterialTemplate> getInfo(@Param("company_id") String company_id);

    @Select("select * from material_template where name like #{name} and ( company_id = #{company_id} or #{company_id}=0 )")
    List<MaterialTemplate> selectMaterialTemplateByName(@Param("name") String name,@Param("company_id") String company_id);

    @Select("select * from material_template where material_id = #{material_id} and ( company_id = #{company_id} or #{company_id}=0 )")
    List<MaterialTemplate> selectMaterialTemplateById(@Param("material_id") int material_id,@Param("company_id") String company_id);

    @Insert("insert into material_template(material_id, name , attribute, company_id) values ( #{material_id} , #{name} ,#{attribute},#{company_id})")
    Integer addMaterialTemplate(MaterialTemplate materialTemplate);

    @Delete("delete from material_template where name=#{name}  and ( company_id = #{company_id} or #{company_id}=0 )")
    int deleteMaterialTemplateByName(@Param("name") String name,@Param("company_id") String company_id);

    @Select("select count(*) from material_template where material_id = #{material_id} and ( company_id = #{company_id} or #{company_id}=0 )")
    Integer countMaterialId(@Param("material_id")Integer material_id,@Param("company_id")Integer company_id );

    //下面的是设备模板相关的mapper
    @Select("select * from equipment_template where ( company_id = #{company_id} or #{company_id}=0 )")
    List<EquipmentTemplate> getEquipmentInfo(@Param("company_id") String company_id);

    @Select("select * from equipment_template where name like #{name} and ( company_id = #{company_id} or #{company_id}=0 )")
    List<EquipmentTemplate> selectEquipmentTemplateByName(@Param("name") String name,@Param("company_id") String company_id);

    @Select("select * from equipment_template where equipment_id = #{equipment_id} and ( company_id = #{company_id} or #{company_id}=0 )")
    List<EquipmentTemplate> selectEquipmentTemplateById(@Param("equipment_id") int equipment_id,@Param("company_id") String company_id);

    @Insert("insert into equipment_template(equipment_id, name , attribute , company_id ) values(#{equipment_id},#{name},#{attribute},#{company_id})")
    Integer addEquipmentTemplate(EquipmentTemplate equipmentTemplate);

    @Delete("delete from equipment_template where name=#{name} and ( company_id = #{company_id} or #{company_id}=0 )")
    int deleteEquipmentTemplateByName(@Param("name") String name,@Param("company_id") String company_id);


}
