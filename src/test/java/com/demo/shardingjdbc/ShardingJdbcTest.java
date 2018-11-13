package com.demo.shardingjdbc;

import com.demo.entity.UserEntity;
import com.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xusheng
 * @Create 2018-11-12 14:08
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mybatis/spring-mybatis.xml","classpath:shardingjdbc/sharding-jdbc.xml"})
public class ShardingJdbcTest {
    public  static ApplicationContext context=null;
    static {
        context = new ClassPathXmlApplicationContext("mybatis/spring-mybatis.xml","shardingjdbc/sharding-jdbc.xml");

    }



    @Test
    public void testInsert(){
        UserMapper mapper = context.getBean(UserMapper.class);
        mapper.insertOne(new UserEntity(5, "xxzzz", 11,new Date()));
        mapper.insertOne(new UserEntity(6, "xxzzzxxx", 11,new Date()));
        mapper.insertOne(new UserEntity(7, "xxzzzzzz", 11,new Date()));

        System.out.println(mapper.selectByPk(1));
        System.out.println(mapper.selectByPk(2));


    }

    @Test
    public void testSelcet(){
        UserMapper mapper = context.getBean(UserMapper.class);

        List<UserEntity> userEntities = mapper.selectList();
        System.out.println(userEntities.size());

        userEntities.forEach(item-> System.out.println(item));

    }
}
