package com.jingxuan.demo.mapper;

import com.jingxuan.demo.BaseMapperTest;
import com.jingxuan.demo.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(1);
        assertNotNull(user);
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}