package com.jingxuan.demo.mapper;

import com.jingxuan.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jingxuan
 */
@Mapper
public interface UserMapper {

    /**
     * delete user by primary key
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert user
     *
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * insert selective user
     *
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * select user by primary key
     *
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);

    /**
     * update user by primary key selective
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * update user by primary key
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);
}