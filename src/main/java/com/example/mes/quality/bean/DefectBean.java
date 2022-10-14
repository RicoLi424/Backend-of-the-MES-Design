package com.example.mes.quality.bean;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: XiaoYu
 * @Date: 2021/07/08/8:39
 * @Description:瑕疵清单实体类
 */

public class DefectBean implements Serializable{
    String defectType;
    String defectCode;
    String classification;
    String status;
    String isDeleted;
    String createdTime;
    String createdBy;
    String modifiedTime;
    String ModifiedBy;
    Integer company_id;

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public void setDefectType(String defectType) {
        this.defectType = defectType;
    }

    public void setDefectCode(String defectCode) {
        this.defectCode = defectCode;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public void setModifiedBy(String modifiedBy) {
        ModifiedBy = modifiedBy;
    }

    public String getDefectType() {
        return defectType;
    }

    public String getDefectCode() {
        return defectCode;
    }

    public String getClassification() {
        return classification;
    }

    public String getStatus() {
        return status;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public String getModifiedBy() {
        return ModifiedBy;
    }
}
