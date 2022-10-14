package com.example.mes.process.Mapper;

import com.example.mes.process.Entity.TemplateMaterial;
import com.example.mes.process.Vo.MaterialVo.*;
import com.example.mes.process.Vo.PageVo.PageVo;
import com.example.mes.template.entity.MaterialTemplate;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

public interface MaterialMapper {
    @Select("select * from template_material where ( company_id = #{company_id} )")
    List<TemplateMaterial> getTemplateMaterials( @Param("company_id")String company_id);
    @Select("select * from template_material where  company_id = #{company_id}  and material_id = #{material_id} ")
    List<TemplateMaterial> getTemplateMaterialByID(@Param("company_id")String company_id,@Param("material_id") String material_id);
    @Insert("insert into template_material(material_id, name , attribute, attribute_value, company_id) values ( #{material_id} , #{name} ,#{attribute},#{attribute_value},#{company_id})")
    Integer addTemplateMaterial(TemplateMaterial templateMaterial);
    @Delete("delete from template_material where name=#{name}  and ( company_id = #{company_id} or #{company_id}=0 )")
    int deleteTemplateMaterialByName(@Param("name") String name,@Param("company_id") String company_id);

    List<QueryMaterialVo> getMaterials(@Param("pageVo")PageVo pageVo,@Param("company_id") Integer company_id);
    //跟据物料id查询对应物料的信息
    QueryMaterialVo getMaterialByID(@Param("material_id") String material_id,Integer company_id);
    //增加一个物料
    List<QueryMaterialVo> getMaterialByName(@Param("name") String name,@Param("company_id") String company_id);
    boolean addMaterial(@Param("insertMaterialVo") InsertMaterialVo insertMaterialVo);
    //根据物料id删除一个物料
    boolean deleteMaterialByID(@Param("deleteMaterialVo") DeleteMaterialVo deleteMaterialVo);
    //修改一个物料，status与comments
    boolean updateMaterialByID(@Param("updateMaterialVo") UpdateMaterialVo updateMaterialVo);

    //根据产品ID——pro_id获得物料清单
    ArrayList<QueryProMaterialVo> getProMaterialListsByProID(@Param("product_id") String product_id);
    //增加物料清单
    boolean addProMaterialLists(@Param("list") ArrayList<InsertProMaterialVo> insertProMaterialVos);
    //删除物料清单（用于修改前的删除，再重新插入，作为修改
    boolean deleteProMaterialLists(@Param("product_id") String product_id);

    int getCount();

    int check(@Param("name") String name,@Param("size") String size);

    int getIndex();


}
