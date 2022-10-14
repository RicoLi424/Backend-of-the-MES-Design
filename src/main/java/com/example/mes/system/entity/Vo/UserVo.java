package com.example.mes.system.entity.Vo;


import com.example.mes.system.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserVo {

    public String filter_name;
    public Integer filter_id;
    public String filter_user_name;
    public List<String> filter_department;
    public List<String> filter_role;
    public Integer pageSize;
    public Integer pageNum;
    public String sort;
    public String sortMethod;
    public User user;

    public UserVo() {
    }

    public UserVo(String filter_name, Integer filter_id, String filter_user_name, List<String> filter_department, List<String> filter_role, Integer pageSize, Integer pageNum, String sort, String sortMethod,User user) {
        this.filter_name = filter_name;
        this.filter_id = filter_id;
        this.filter_user_name = filter_user_name;
        this.filter_department = filter_department;
        this.filter_role = filter_role;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.sort = sort;
        this.sortMethod = sortMethod;
        this.user = user;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }


    public String getFilter_name() {
        return filter_name;
    }

    public void setFilter_name(String filter_name) {
        this.filter_name = filter_name;
    }

    public Integer getFilter_id() {
        return filter_id;
    }

    public void setFilter_id(Integer filter_id) {
        this.filter_id = filter_id;
    }

    public String getFilter_user_name() {
        return filter_user_name;
    }

    public void setFilter_user_name(String filter_user_name) {
        this.filter_user_name = filter_user_name;
    }

    public List<String> getFilter_department() {
        return filter_department;
    }

    public void setFilter_department(List<String> filter_department) {
        this.filter_department = filter_department;
    }

    public List<String> getFilter_role() {
        return filter_role;
    }

    public void setFilter_role(List<String> filter_role) {
        this.filter_role = filter_role;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSortMethod() {
        return sortMethod;
    }

    public void setSortMethod(String sortMethod) {
        this.sortMethod = sortMethod;
    }

}
