package com.jingxuan.demo.servie.impl;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.jingxuan.demo.mapper.UserMapper;
import com.jingxuan.demo.model.User;
import com.jingxuan.demo.servie.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Xuan Jing
 * @Date: 2019/11/24 4:19 PM
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(key = "#id", value = "user")
    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
