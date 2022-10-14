package com.example.mes.plan.service;

import com.example.mes.plan.entity.CustomOrderForm;
import com.example.mes.plan.dao.CustomOrderFormDao;
import com.example.mes.plan.entity.Line;
//import com.example.mes.plan.entity.ProductionLine;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *对应CustomOrderFormDao
 *
 *
 */
@Service
public class CustomOrderFormService {

    @Resource
    private CustomOrderFormDao customOrderFormDao;

    /**
     *
     * 分页查询
     * @param offset
     * @param limit
     * @return
     */
    public List<CustomOrderForm> selectAllCustomOrderForm(int offset, int limit,String company_id)
    {
        return customOrderFormDao.findCustomOrderFormByLimit(offset,limit,company_id);
    }
    /**
     *
     * 多条件分页查询
     * @param offset
     * @param limit
     * @param company_id
     * @return
     */
    public List<CustomOrderForm> searchCustomOrderForm(
            String no, String company,
            String created_time_start, String created_time_end,
            String expected_time_start, String expected_time_end,
            int offset, int limit, String company_id)
    {
        return customOrderFormDao.searchCustomOrderFormByLimit(
                no, company,
                created_time_start, created_time_end,
                expected_time_start,expected_time_end,
                offset, limit,company_id);
    }
    /**
     *
     * 根据id更新需求单
     * @param data
     * @return
     */
    public void updateCustomOrderForm(CustomOrderForm data)
    {
        customOrderFormDao.updateCustomOrderForm(data);
    }

    /**
     *
     * 根据id逻辑删除需求单
     * @param id
     * @return
     */
    public void deleteCustomOrderForm(String id)
    {
        customOrderFormDao.deleteCustomOrderForm(id);
    }
    /**
     *
     * 根据product_id查询生产线
     * @param product_id
     * @return
     */
//    public List<ProductionLine> getLinesByProduct(String product_id)
//    {
//        return customOrderFormDao.getLinesByProduct(product_id);
//    }
//

}
