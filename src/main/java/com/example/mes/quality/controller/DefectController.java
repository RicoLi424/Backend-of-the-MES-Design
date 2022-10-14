package com.example.mes.quality.controller;

import com.example.mes.quality.bean.DefectBean;
import com.example.mes.quality.service.DefectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

//@EnableOpenApi
//@Api(description="瑕疵管理")
@RestController
public class DefectController {
    @Autowired
    DefectServiceImpl defectService;

//    @ApiOperation(value = "所有瑕疵")
    @CrossOrigin
    @GetMapping("/defect/all")
    public List<DefectBean> defectAll(@RequestParam("company_id") String company_id) throws Exception{
        List<DefectBean> defectBean = defectService.getAllDefect(company_id);
        return defectBean;
    }

//    @ApiOperation(value = "返回搜索瑕疵")
    @CrossOrigin
    @GetMapping("/defect/search")
    public List<DefectBean> defectSearch(@RequestParam("keywords") String keyword,@RequestParam("company_id") String company_id) throws Exception{
        if("".equals(keyword)){
//            System.out.println(defectService.getSearchDefect(keyword,company_id));

            return defectAll(company_id);

        }else{
//            System.out.println(defectService.getSearchDefect(keyword,company_id));
//            System.out.println(company_id);
            return defectService.getSearchDefect(keyword,company_id);
        }
    }

//    @ApiOperation(value = "删除瑕疵")
    @CrossOrigin
    @PostMapping("/defect/delete")
    public void deleteDefectByCode(@RequestBody DefectBean defectBean) throws Exception{
        defectService.deleteByCode(defectBean.getDefectCode(),Integer.toString(defectBean.getCompany_id()));
    }

//    @ApiOperation(value = "添加瑕疵")
    @CrossOrigin
    @PostMapping("/defect/add")
    public void addDefect(@RequestBody DefectBean defectBean) throws Exception{
        defectBean.setStatus("1");
        defectBean.setIsDeleted("0");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        defectBean.setCreatedTime(timestamp.toString());
        defectBean.setCreatedBy("x");
        defectBean.setModifiedTime(timestamp.toString());
        defectBean.setModifiedBy("x");
        defectService.addDefect(defectBean);
    }

    //    @ApiOperation(value = "返回瑕疵分类")
    @CrossOrigin
    @GetMapping("/defect/{keyword}/defects")
    public List<DefectBean> defectByClassification(@PathVariable("keyword") String keyword,@RequestParam("company_id") String company_id) throws Exception{
        if(!keyword.equals("全部瑕疵")){
            return defectService.getDefectByClassification(keyword,company_id);
        }else{
            return defectAll(company_id);
        }
    }
    //    @ApiOperation(value = "返回瑕疵代码及名字")

    @CrossOrigin
    @GetMapping("/defect/typeAndCode")
    public List<DefectBean> defectTypeAndCode(@RequestParam("company_id") String company_id) throws Exception{
        return defectService.getDefectTypeAndCode(company_id);
    }
}
