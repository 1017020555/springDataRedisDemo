package com.lc.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-redis.xml"})
public class Hash {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void testPut(){
        redisTemplate.boundHashOps("User").put("name","mike");
        redisTemplate.boundHashOps("User").put("name1","mike1");
        redisTemplate.boundHashOps("User").put("name2","mike2");
    }
    @Test
    public void testGetOne(){
        Object o = redisTemplate.boundHashOps("User").get("name1");
        System.out.println(o);
    }
    @Test
    public void testGetAll(){
        Map<String,String> entries = redisTemplate.boundHashOps("User").entries();
        Set<Map.Entry<String, String>> set = entries.entrySet();
        for (Map.Entry entry:set){
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key+"--"+value);
        }
    }
    @Test
    public void testDelete(){
        redisTemplate.boundHashOps("User").delete("name1");
    }
}
