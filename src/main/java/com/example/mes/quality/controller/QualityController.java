package com.example.mes.quality.controller;

import com.alibaba.fastjson.JSON;
import com.example.mes.quality.bean.QualityBean;
import com.example.mes.quality.service.QualityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//@EnableOpenApi
//@Api(description="瑕疵管理")
@RestController
public class QualityController {

    @Autowired
    QualityServiceImpl qualityService;


    //    @ApiOperation(value = "添加质检结果")
    @CrossOrigin
    @PostMapping("/quality/addResults")
    public void addResults(@RequestBody QualityBean qualityBean) throws Exception{

        qualityBean.setStatus("1");
        qualityBean.setIsDeleted("0");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        qualityBean.setCreatedTime(timestamp.toString());
        qualityBean.setCreatedBy("x");
        qualityBean.setModifiedTime(timestamp.toString());
        qualityBean.setModifiedBy("x");
        qualityService.addResults(qualityBean);
    }

    //    @ApiOperation(value = "返回所有质检结果")
    @CrossOrigin
    @GetMapping("/quality/getResults")
    public List<QualityBean> getResults(@RequestParam("company_id") String company_id) throws Exception{
        return qualityService.getResults(company_id);
    }

    //根据list_id查询质检结果
    @CrossOrigin
    @GetMapping("/quality/queryResultByList")
    public List<QualityBean> queryResultByList(String list_id) {

        return qualityService.queryResultByList(list_id);
    }

    @CrossOrigin
    @GetMapping("/quality/getDefectCode")
    public String getDefectCode(@RequestParam("defectType") List<String> list,@RequestParam("company_id") String company_id) {

        try {
            return JSON.toJSONString(qualityService.getDefectCode(list,company_id));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("产线下拉框生成失败！");
            return "";
        }
    }



    //    @ApiOperation(value = "返回某天某车间某生产线的数据")
    @CrossOrigin
    @GetMapping("/quality/echarts")
    public List<List<?>> getResultsByDate(@RequestParam("keywords") String keyword) throws Exception{
        String[] str1 = keyword.split("~");
        String[] str2 = {str1[1],str1[2],str1[3]};
        System.out.println(str1[3]);
        //得到某日期某车间某生产线的不合格率的值
        List<Double> list1 = new ArrayList<>();
        List<QualityBean> qualityBeans = null;
        qualityBeans=qualityService.getResultsByDate(str1);
        for(int i=0; i<qualityBeans.size();i++){
            Double num = 1-qualityBeans.get(i).getDefectRatio();
            BigDecimal bd = new BigDecimal(num);
            num = bd.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
            list1.add(num);
        }
        //得到某车间某生产线的不合格率的平均值
        List<Double> list2 = new ArrayList<>();
        qualityBeans = qualityService.getResultsByWorkshop(str2);
        for(int i=0; i<qualityBeans.size();i++){
            Double num = 1-qualityBeans.get(i).getDefectRatio();
            BigDecimal bd = new BigDecimal(num);
            num = bd.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
            list2.add(num);
        }
        //得到某车间某生产线的瑕疵组成
        List<String> list3 = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        qualityBeans = qualityService.getResultsByDefectType(str2);
        for(int i=0; i<qualityBeans.size();i++){
            String type = qualityBeans.get(i).getDefectType();
            Integer num = qualityBeans.get(i).getDefectNum();
            String[] str = type.split(",");
            for(int j=0;j<str.length;j++)
                if(!str[j].equals(" ")){
                    if(!hm.containsKey(str[j]))
                        hm.computeIfAbsent(str[j],k->num);
                    else
                        hm.computeIfPresent(str[j],(k,v)->v+num);
                }
        }
        for (HashMap.Entry<String, Integer> entry : hm.entrySet())
            list3.add(entry.getKey()+"-"+entry.getValue());

        //得到某日期某车间某生产线的瑕疵组成
        List<String> list4 = new ArrayList<>();
        hm.clear();
        qualityBeans = qualityService.getResultsByDefectTypePart(str1);
        for(int i=0; i<qualityBeans.size();i++){
            String type = qualityBeans.get(i).getDefectType();
            Integer num = qualityBeans.get(i).getDefectNum();
            String[] str = type.split(",");
            for(int j=0;j<str.length;j++)
                if(!str[j].equals(" ")){
                    if(!hm.containsKey(str[j]))
                        hm.computeIfAbsent(str[j],k->num);
                    else
                        hm.computeIfPresent(str[j],(k,v)->v+num);
                }
        }
        for (HashMap.Entry<String, Integer> entry : hm.entrySet())
            list4.add(entry.getKey()+"-"+entry.getValue());
        List<List<?>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        return lists;
    }
}
