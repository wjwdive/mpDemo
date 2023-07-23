package com.wjw.mpdemo.service;

import com.wjw.mpdemo.entity.User;
import com.wjw.mpdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserById(Integer id) {
        User user = userMapper.findById(id);
        if (user != null) {
            return  user;
        }else {
            return null;
        }
    }

    @Override
    public User getUserByName(String username) {
       User user = userMapper.findByUsername(username);
       if (user != null) {
           return user;
       }else  {
           return null;
       }
    }

    public boolean isExitUsername(String username) {
        User user = userMapper.findByUsername(username);
        if (user != null) {
            return true;
        }else{
            return false;
        }
    }


}
