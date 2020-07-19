package com.jingxuan.demo.servie.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jingxuan.demo.dao.UserInfoDao;
import com.jingxuan.demo.entity.UserInfoEntity;
import com.jingxuan.demo.servie.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Xuan Jing
 * @Date: 2020/7/13 10:31 PM
 */
@Service
@Transactional
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {
}
