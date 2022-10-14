package com.example.mes.system.entity.Vo;

import com.example.mes.system.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserDeleteVo {
    private List<User> userList;
    private User user;
}
