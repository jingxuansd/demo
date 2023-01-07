package com.jingxuan.demo.mapper;

import com.jingxuan.demo.BaseMapperTest;
import com.jingxuan.demo.BaseTest;
import com.jingxuan.demo.MySQLExtension;
import com.jingxuan.demo.model.User;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

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
        assertTrue(userMapper.deleteByPrimaryKey(2) > 0);;
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