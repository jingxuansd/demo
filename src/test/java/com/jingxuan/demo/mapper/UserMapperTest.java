package com.jingxuan.demo.mapper;

import com.jingxuan.demo.BaseMapperTest;
import com.jingxuan.demo.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: Xuan Jing
 * @Date: 2020/6/25 11:31 PM
 */
public class UserMapperTest extends BaseMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Before
    public void init() {
        executeScriptsWithReLoadSchema("/db/user_insert.sql");
    }

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