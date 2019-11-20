package com.lc.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-redis.xml"})
public class List {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void testLeftPush(){
        redisTemplate.boundListOps("list").leftPush("1");
    }
    @Test
    public void testRightPush(){
        redisTemplate.boundListOps("list").rightPush("2");
        redisTemplate.boundListOps("list").rightPush("3");
    }
    @Test
    public void testRightRange(){
        java.util.List list = redisTemplate.boundListOps("list").range(0, 10);
        System.out.println(list);
    }
    @Test
    public void testDelete(){
        Object list = redisTemplate.boundListOps("list").rightPop();
        System.out.println(list);
    }
}
