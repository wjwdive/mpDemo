package com.wjw.mpdemo.controller;

import com.wjw.mpdemo.entity.User;
import com.wjw.mpdemo.mapper.UserMapper;
import com.wjw.mpdemo.service.UserService;
import com.wjw.mpdemo.uitils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    //自动装配 mapper spring的功能
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> query() {
        List<User> list = userMapper.find();
        System.out.println(list);
        return list;
    }

    @PostMapping("/user/insert")
    public ResultData insertUser(User user) {
        if (userService.getUserByName(user.getUsername()) != null) {
            return ResultData.fail(500,"用户名已存在");
        }
        int i = userMapper.insertUser(user);
        if (i > 0){
            return ResultData.success("插入成功");
        }else {
            return ResultData.fail(500,"插入失败");
        }
    }

    @PostMapping("/user/delete")
    public String delete(int id) {
        int i = userMapper.delete(id);
        if (i > 0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }
}
