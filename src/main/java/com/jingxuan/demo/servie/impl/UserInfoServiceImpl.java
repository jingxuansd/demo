package com.jingxuan.demo.servie.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jingxuan.demo.dao.UserInfoDao;
import com.jingxuan.demo.entity.UserInfoEntity;
import com.jingxuan.demo.servie.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Xuan Jing
 * @Date: 2020/7/13 10:31 PM
 */
@Service
@Slf4j
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    public String getName() {
        return "test";
    }

    @Transactional
    @Override
    public Integer updateAge(Long id) throws InterruptedException {
        UserInfoEntity userInfoEntity = super.getById(id);
        log.info("age: {}", userInfoEntity.getAge());
        int age = userInfoEntity.getAge() + 1;
        Thread.sleep(10000);
//        userInfoEntity.setAge(age);
//        userInfoEntity.setAge(userInfoEntity.getAge() + 1);
//        super.updateById(userInfoEntity);
        userInfoDao.increaseAge(id);

        return age;
    }
}
