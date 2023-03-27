package com.zoe.redisdemo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>标题: </p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2023</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @version: 1.0
 * @author: wengcong
 * @date: 2023-03-15
 */
@RestController
@RequestMapping("redis")
@Tag(name = "redis")
@Slf4j
public class RedisTestController {

    @Resource
    private RedisTemplate redisTemplate;

    @Operation(summary = "根据key获取存在redis中的值")
    @Parameter(name = "key",description = "redis的key", required = true)
    @GetMapping("getRedisKey/{key}")
    public String getRedisKey(@PathVariable("key") String key){
        log.info(key);
        log.info((String) redisTemplate.opsForValue().get(key));
        return (String) redisTemplate.opsForValue().get(key);
    }

    @Operation(summary = "插入redis")
    @Parameter(name = "key",description = "redis的key", required = true)
    @Parameter(name = "value",description = "key的值", required = true)
    @GetMapping("setRedisKeyValue")
    public String setRedisKeyValue(String key, String value){
        redisTemplate.opsForValue().set(key,value);
        if  (redisTemplate.opsForValue().get(key).equals(value)) {
            return "插入redis成功";
        } else {
            return "插入redis失败";
        }
    }


}
