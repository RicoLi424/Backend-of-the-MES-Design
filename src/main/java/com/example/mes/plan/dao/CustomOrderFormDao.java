package com.example.mes.plan.dao;

import com.example.mes.plan.entity.CustomOrderForm;
import com.example.mes.plan.entity.Line;
//import com.example.mes.plan.entity.ProductionLine;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *
 * 查询客户订单表
 */
@Mapper
public interface CustomOrderFormDao {

    /**
     *
     * 所有客户订单分页查询
     * @param offset
     * @param limit
     * @return
     */
    @Select("select plan_demand_form.no no,plan_demand_form.product_id product_id," +
            "   plan_demand_form.quantity quantity,plan_demand_form.created_time created_time," +
            "   plan_demand_form.expected_date expected_date ,product.type type," +
            "   product.brand brand ,product.company company," +
            "   product.color color ,product.season season ,plan_demand_form.id id" +
            "   from plan_demand_form, product" +
            "   where plan_demand_form.is_deleted=0 and plan_demand_form.product_id = product.product_id and plan_demand_form.company_id = #{company_id} LIMIT #{limit} OFFSET  #{offset}")
    List<CustomOrderForm> findCustomOrderFormByLimit(@Param("offset") int offset,@Param("limit") int limit,@Param("company_id") String company_id);
    /**
     *
     * 多条件客户订单分页查询
     * @param offset
     * @param limit
     * @param company_id
     * @return
     */
    @Select("<script>" +
            "select plan_demand_form.no no,plan_demand_form.product_id product_id," +
            "   plan_demand_form.quantity quantity,plan_demand_form.created_time created_time," +
            "   plan_demand_form.expected_date expected_date ,product.type type," +
            "   product.brand brand ,product.company company," +
            "   product.color color ,product.season season ,plan_demand_form.id id" +
            "   from plan_demand_form, product where" +
            "   <if test=\"no!= null and no!=''\"> plan_demand_form.no = #{no} and</if>" +
            "   <if test=\"company!= null and company!=''\"> product.company = #{company} and</if>" +
            "   <if test=\"company_id!= null and company_id!=''\"> product.company_id = #{company_id} and</if>" +
            "   <if test=\"created_time_start!= null and created_time_start!='' \"> " +
            "       plan_demand_form.created_time > #{created_time_start} and </if>" +
            "   <if test=\"created_time_end!= null and created_time_end!='' \"> " +
            "       #{created_time_end} > plan_demand_form.created_time and </if>" +
            "   <if test=\"expected_time_start!= null and expected_time_start!='' \"> " +
            "       plan_demand_form.expected_date > #{expected_time_start} and </if>" +
            "   <if test=\"expected_time_end!= null and expected_time_end!='' \"> " +
            "       #{expected_time_end} > plan_demand_form.expected_date and </if>" +
            "    plan_demand_form.is_deleted=0 and plan_demand_form.product_id = product.product_id LIMIT #{limit} OFFSET  #{offset}" +
            "</script>")
    List<CustomOrderForm> searchCustomOrderFormByLimit(
            @Param("no") String no, @Param("company") String company,
            @Param("created_time_start") String created_time_start, @Param("created_time_end") String created_time_end,
            @Param("expected_time_start") String expected_time_start, @Param("expected_time_end") String expected_time_end,
            @Param("offset") int offset, @Param("limit") int limit,@Param("company_id") String company_id);

    /*
    @Insert("insert into plan_demand_form (gid,wid,max,min,单位) values (#{CustomOrderForm.gid}, #{CustomOrderForm.wid} ,#{CustomOrderForm.max} ,"+
    "#{CustomOrderForm.min} ,#{CustomOrderForm.单位});")
    void addCustomOrderForm(@Param("CustomOrderForm") CustomOrderForm CustomOrderForm);
    
    */
    @Update("update plan_demand_form set product_id = #{CustomOrderForm.product_id} , quantity = #{CustomOrderForm.quantity} " +
            " , expected_date = #{CustomOrderForm.expected_date}"+
    "where id = #{CustomOrderForm.id}")
    void updateCustomOrderForm(@Param("CustomOrderForm") CustomOrderForm CustomOrderForm);

    @Update("update plan_demand_form set is_deleted = 1 " +
            "where id = #{id}")
    void deleteCustomOrderForm(@Param("id") String id);

//    /**
//     *
//     * 按照product_id查询生产线
//     * @param product_id
//     * @return
//     */
//    @Select("select workshop_line.uuid uuid, workshop_line.name name, workshop_line.workshop_id workshopId," +
//            "   workshop_workshop.name workshopName from workshop_line , workshop_workshop" +
//            "   where workshop_line.routing = #{product_id} \n" +
//            "   and workshop_line.is_deleted=0" +
//            "   and workshop_line.workshop_id=workshop_workshop.id")
//    List<ProductionLine> getLinesByProduct(@Param("product_id") String product_id);
}
