package com.demo;

import com.demo.entity.UserEntity;
import com.demo.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("mybatis/spring-mybatis.xml","shardingjdbc/sharding-jdbc.xml");

        UserMapper mapper = context.getBean(UserMapper.class);



    }
}
