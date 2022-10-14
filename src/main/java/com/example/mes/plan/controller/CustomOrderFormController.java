package com.example.mes.plan.controller;

import com.example.mes.plan.dao.CustomOrderFormDao;
import com.example.mes.plan.entity.CustomOrderForm;
import com.example.mes.plan.entity.Line;
//import com.example.mes.plan.entity.ProductionLine;
import com.example.mes.plan.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * 有关库存上下限信息查询的业务逻辑层
 */
@RestController
@RequestMapping("/customOrderForm")
public class CustomOrderFormController {
    private static final Logger logger = LoggerFactory.getLogger(CustomOrderFormController.class);
    @Resource
    private CustomOrderFormService customOrderFormService;
    private CustomOrderFormDao customOrderFormDao;
    /**
     * 查询所有客户订单信息
     * 对应前端的getCustomOrderFormData请求
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(value ="/allCustomOrderForm",method = RequestMethod.GET)
    public List<CustomOrderForm> CustomOrderForm(int offset, int limit ,String company_id)
    {
        List<CustomOrderForm> customOrderForms = customOrderFormService.selectAllCustomOrderForm(offset,limit,company_id);
        System.out.println(customOrderForms);
        if(!customOrderForms.isEmpty())
        {
            return customOrderForms;
        }
        return null;
    }
    /**
     * 多条件查询客户订单信息
     * 对应前端的searchCustomOrderFormData请求
     * @param no
     * @param company
     * @param created_time_start
     * @param created_time_end
     * @param expected_time_start
     * @param expected_time_end
     * @param offset
     * @param limit
     * @param company_id
     * @return
     */
    @RequestMapping(value ="/searchCustomOrderForm",method = RequestMethod.GET)
    public List<CustomOrderForm> CustomOrderForm(
            String no, String company,
            String created_time_start, String created_time_end,
            String expected_time_start,String expected_time_end,
            int offset, int limit,String company_id) {
        System.out.println(no);
        System.out.println(company);
        List<CustomOrderForm> customOrderForms = customOrderFormService.searchCustomOrderForm(
                no, company,
                created_time_start, created_time_end,
                expected_time_start,expected_time_end,
                offset, limit,company_id);
        System.out.println(customOrderForms);
        if(!customOrderForms.isEmpty())
        {
            return customOrderForms;
        }
        return null;
    }

    /**
     * 修改指定id的需求单信息
     * 对应前端的updateCustomOrderFormData请求
     * @param id
     * @param expected_date
     * @param quantity
     * @param product_id
     * @return
     */
    @RequestMapping(value ="/updateCustomOrderForm")//,method = RequestMethod.POST)
    public void UpdateCustomOrderForm(String id, String expected_date , String quantity , String product_id)
    {
        try{
            CustomOrderForm form=new CustomOrderForm(id,expected_date,quantity,product_id);
            customOrderFormService.updateCustomOrderForm(form);
        }catch (Error e){
            System.out.println(e);
        }
    }
    /**
     * 逻辑删除指定id的需求单信息
     * 对应前端的deleteCustomOrderFormData请求
     * @param id
     * @return
     */
    @RequestMapping(value ="/deleteCustomOrderForm")
    public void UpdateCustomOrderForm(String id)
    {
        try{
            System.out.println(id);
            customOrderFormService.deleteCustomOrderForm(id);
        }catch (Error e){
            System.out.println(e);
        }
    }
    /**
     * 查询指定的product_id生产线
     * 对应前端的/getLinesByProduct请求
     * @param product_id
     * @return
     */
//    @RequestMapping(value ="/getLinesByProduct")
//    public List<ProductionLine> GetLinesByProduct(String product_id)
//    {
//        try{
//            List<ProductionLine> lines = customOrderFormService.getLinesByProduct(product_id);
//            customOrderFormService.getLinesByProduct(product_id);
//
//            if(!lines.isEmpty())
//            {
//                return lines;
//            }
//            return null;
//        }catch (Error e){
//            System.out.println(e);
//            return null;
//        }
//    }


}
