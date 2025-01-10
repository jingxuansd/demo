package com.jingxuan.demo.mapper;

import com.jingxuan.demo.model.User;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.*;

/**
 * @Author: Xuan Jing
 * @Date: 2020/6/25 11:31 PM
 */
@MybatisTest()
@ActiveProfiles("test")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void deleteByPrimaryKey() {
        assertTrue(userMapper.deleteByPrimaryKey(2) > 0);
    }

    @Test
    public void insert() {
        User user = new User();
        user.setName("jingxuan002");
        user.setUid(321L);
        assertTrue(userMapper.insert(user)>0);
    }

    @Test
    public void selectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(1);
        assertNotNull(user);
    }
}