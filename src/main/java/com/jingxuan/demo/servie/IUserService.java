package com.jingxuan.demo.servie;

import com.jingxuan.demo.model.User;

/**
 * @Author: Xuan Jing
 * @Date: 2019/11/24 4:18 PM
 */
public interface IUserService {
    /**
     * get user by id
     *
     * @param id
     * @return
     */
    User getUserById(int id);
}
