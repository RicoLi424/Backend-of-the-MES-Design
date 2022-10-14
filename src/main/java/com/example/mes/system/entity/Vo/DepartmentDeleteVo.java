package com.example.mes.system.entity.Vo;

import com.example.mes.system.entity.Department;
import com.example.mes.system.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class DepartmentDeleteVo {
    private List<Department> departmentList;
    private User user;

}
