package com.lc.core;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-redis.xml"})
public class String {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void testSet(){
//    增加
//        redisTemplate.boundValueOps("a").set("臭弟弟");

//    查询
//        Object a = redisTemplate.boundValueOps("a").get();
//        System.out.println(a);

//    删除
//        redisTemplate.delete("a");
//        Object a1 = redisTemplate.boundValueOps("a").get();
//        System.out.println(a1);
//改
        redisTemplate.boundValueOps("a").set("憨憨健");
        Object a2 = redisTemplate.boundValueOps("a").get();
        System.out.println(a2);

    }
}
