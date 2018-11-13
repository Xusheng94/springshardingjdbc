package com.demo.mapper;

import com.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description
 * @Author xusheng
 * @Create 2018-11-12 13:35
 * @Version 1.0
 **/
@Mapper
public interface UserMapper {

    int insertOne(UserEntity user);

    UserEntity selectByPk(Integer id);

    List<UserEntity> selectList();


}
