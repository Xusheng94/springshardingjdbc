package com.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description
 * @Author xusheng
 * @Create 2018-11-12 13:33
 * @Version 1.0
 **/
@Data
public class UserEntity {

    private Integer id;

    private String name;

    private Integer age;

    private Date createTime;

    public UserEntity(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UserEntity(Integer id, String name, Integer age, Date createTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.createTime = createTime;
    }
}
