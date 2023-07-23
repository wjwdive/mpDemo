package com.wjw.mpdemo.service;

import com.wjw.mpdemo.entity.User;

public interface UserService {
    User getUserById(Integer id);
    User getUserByName(String username);
    boolean isExitUsername(String username);
}
