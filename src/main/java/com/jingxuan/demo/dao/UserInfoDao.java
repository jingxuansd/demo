package com.jingxuan.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jingxuan.demo.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Xuan Jing
 * @Date: 2020/7/13 10:27 PM
 */
@Mapper
public interface UserInfoDao extends BaseMapper<UserInfoEntity> {

    void increaseAge(@Param("id") Long id);
}
