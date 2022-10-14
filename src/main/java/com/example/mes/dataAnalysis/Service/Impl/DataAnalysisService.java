package com.example.mes.dataAnalysis.Service.Impl;

import com.example.mes.dataAnalysis.Mapper.DataAnalysisMapper;
import com.example.mes.dataAnalysis.Service.IDataAnalysisService;
import com.example.mes.dataAnalysis.Vo.IDPair;
import com.example.mes.dataAnalysis.Vo.MaterialStock;
import com.example.mes.dataAnalysis.Vo.MaterialStockChange;
import com.example.mes.dataAnalysis.Vo.ProductionSchedule;
import com.example.mes.process.Vo.PageVo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class DataAnalysisService implements IDataAnalysisService {

    @Autowired(required = false)
    DataAnalysisMapper mapper;
    @Override
    public List<String> getDemandFormNosByDate(String date,String company_id) {
        try {
            return mapper.getDemandFormNosByDate(date,company_id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:根据预计完成日期获得预计完成客户订单号失败！");
            return null;
        }
    }
    @Override
   public HashMap<String,Object>getProcessByPlanId(String plan_id){
        try {System.out.println(plan_id);
            ArrayList<String> process_ids = new ArrayList<>();
            ArrayList<String> process_names = new ArrayList<>();
            ArrayList<Integer> realCounts = new ArrayList<>();
            ArrayList<Integer> planCounts = new ArrayList<>();
            process_ids.addAll(mapper.getProcessPlanId(plan_id));
            process_names.addAll(mapper.getProcessPlanName(plan_id));
            int i;
            for ( i =0;i <process_ids.size();i++)
            {

                realCounts.addAll(mapper.getProcessProducedQuantity(process_ids.get(i)));
                planCounts.addAll(mapper.getProcessDemandQuantity(process_ids.get(i)));
            }
            HashMap<String,Object> data = new HashMap<>();
            data.put("realCounts",realCounts);
            data.put("planCounts",planCounts);
            data.put("process_ids",process_ids);
            data.put("process_names",process_names);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取计划单信息失败");
            return null;
        }
    }
    //计划单完成状况的方法
    @Override
    public  HashMap<String,Object> getPlanByProductId(String product_id) {
        try {System.out.println(product_id);
            ArrayList<String> plan_ids = new ArrayList<>();
            ArrayList<String> plan_nos = new ArrayList<>();
            ArrayList<Integer> realCounts = new ArrayList<>();
            ArrayList<Integer> planCounts = new ArrayList<>();
            plan_ids.addAll(mapper.getPlanProductId(product_id));
            plan_nos.addAll(mapper.getPlanProductno(product_id));
            System.out.println(plan_nos);
            int i;
        for ( i =0;i <plan_ids.size();i++)
        {

            realCounts.addAll(mapper.getPlanProducedQuantity(plan_ids.get(i)));
            planCounts.addAll(mapper.getPlanDemandQuantity(plan_ids.get(i)));
        }
            HashMap<String,Object> data = new HashMap<>();
            data.put("realCounts",realCounts);
            data.put("planCounts",planCounts);
            data.put("plan_ids",plan_ids);
            data.put("plan_nos",plan_nos);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取计划单信息失败");
            return null;
        }
    }
    @Override
    public HashMap<String, Object> getFinishInfoById(String no) {
        try {
            List<IDPair> idPairs = mapper.getIDPairs(no);
            ArrayList<String> categorys = new ArrayList<>();
            ArrayList<Integer> realCounts = new ArrayList<>();
            ArrayList<Integer> planCounts = new ArrayList<>();
            ArrayList<String> plan_ids = new ArrayList<>();
            ArrayList<String> product_ids = new ArrayList<>();
            for(IDPair idPair:idPairs){
                String name = mapper.getProductNameByID(idPair.getProduct_id());
                ProductionSchedule productionSchedule = new ProductionSchedule(mapper.getDemandQuantity(idPair.getId()),mapper.getProducedQuantity(idPair.getId()));
                categorys.add(name);
                realCounts.add(productionSchedule.getProduced_quantity());
                planCounts.add(productionSchedule.getDemand_quantity());
                product_ids.add(idPair.getProduct_id());
                plan_ids.addAll(mapper.getDemandPlanId(idPair.getId()));
            }
            HashMap<String,Object> data = new HashMap<>();
            data.put("categorys",categorys);
            data.put("realCounts",realCounts);
            data.put("planCounts",planCounts);
            data.put("plan_ids",plan_ids);
            data.put("product_ids",product_ids);
            return data;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:获取生产进度失败！");
            return null;
        }
    }

    @Override
    public HashMap<String,Object> getMaterialStock(int pageOffset, int pageSize, String company_id) {
        try {
            System.out.println(company_id);
            HashMap<String,Object> data = new HashMap<>();
            List<MaterialStock> materials = mapper.getMaterialStock(new PageVo(pageOffset,pageSize),company_id);
            for(MaterialStock materialStock:materials){
                MaterialStock i = mapper.getMaterialInfoByID(materialStock.getMaterial_id(),company_id);
                materialStock.setName(i.getName());

                materialStock.setSize(i.getSize());
            }
            int count = mapper.getCount(company_id);
            data.put("materials",materials);
            data.put("count",count);
            return data;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:获取库存信息失败！");
            return null;
        }
    }


    @Override
    public HashMap<String, Object> getMaterialStockByInfo(String name, String size) {
        try {
            size=size.replace(",", "\",\"");
            size=size.replace(":", "\":\"");
            size="{\""+size;
            size=size+"\"}";
            String material_id = mapper.getMaterialIDByInfo(name,size);
            HashMap<String,Object> data = new HashMap<>();
            ArrayList<MaterialStock> materials = new ArrayList<>();
            MaterialStock materialStock = mapper.getMaterialStockByID(material_id);
            if (materialStock == null){
                materialStock = new MaterialStock(material_id,name,size,0);
            }else{
                materialStock.setName(name);
                materialStock.setSize(size);

            }
            materials.add(materialStock);
            data.put("materials",materials);
            data.put("count",1);
            return data;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:根据物料信息获取库存信息失败！");
            return null;
        }
    }

    @Override
    public HashMap<String, Object> getMaterialStockChanges(String material_id) {
        try {
            List<MaterialStockChange> lists = mapper.getMaterialStockChanges(material_id);
            ArrayList<String> dates = new ArrayList<>();
            ArrayList<Integer> stocks = new ArrayList<>();
            for(MaterialStockChange item:lists){
                dates.add(item.getDate().substring(5,10));
                stocks.add(item.getStock());
            }
            Collections.reverse(dates);
            Collections.reverse(stocks);
            //获得当前的物料库存
            MaterialStock materialStock = mapper.getMaterialStockByID(material_id);
            int stock;
            if(materialStock==null)
                stock=0;
            else
                stock = mapper.getMaterialStockByID(material_id).getCount();
            dates.add("当前");
            stocks.add(stock);

            HashMap<String,Object> data = new HashMap<>();
            data.put("dates",dates);
            data.put("stocks",stocks);
            return data;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:获取物料库存变化列表失败！");
            return null;
        }
    }


    //将指定日期的库存写入库存统计表
    @Override
    public boolean addMaterialStockChanges(String date) {
        try {
            List<String> lists = mapper.getMaterialIDs();
            for(String material_id:lists){
                MaterialStock materialStock = mapper.getMaterialStockByID(material_id);
                int stock;
                if(materialStock==null)
                    stock=0;
                else
                    stock = mapper.getMaterialStockByID(material_id).getCount();
                MaterialStockChange materialStockChange = new MaterialStockChange(date,stock);
                materialStockChange.setMaterial_id(material_id);
                mapper.addMaterialStockChanges(materialStockChange);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println();
            return false;
        }
    }

}
