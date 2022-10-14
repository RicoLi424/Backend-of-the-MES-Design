package com.example.mes.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mes.system.entity.Apply;
import com.example.mes.system.entity.User;
import com.example.mes.system.entity.Vo.UserUpdateVo;
import com.example.mes.system.entity.Vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface UserService extends IService<User> {
    public List<User> findUserAll();

    public List<User> queryUserList(UserVo userVo);

    public Integer getLastCount(Integer company_id);

    public List<String> queryAllRoleName(UserVo userVo);

    public List<String> queryAllDepartmentName(UserVo userVo);

    public HashMap<String, Object> deleteUsers(User user, int handler);

    public User findUserById(Integer id,Integer company_id);

    public void userAdd(UserUpdateVo userUpdateVo);

    public void userUpdate(UserUpdateVo userUpdateVo);

    void userApply(UserUpdateVo userUpdateVo);

    Apply findApply(UserUpdateVo userUpdateVo);

    String findUserDepartment(UserUpdateVo userUpdateVo);

    String findUserRole(UserUpdateVo userUpdateVo);

}
