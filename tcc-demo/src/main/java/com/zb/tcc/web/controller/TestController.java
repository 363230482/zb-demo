package com.zb.tcc.web.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.zb.demo.util.json.JacksonJsonMapper;
import com.zb.tcc.domain.user.Department;
import com.zb.tcc.domain.user.User;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangbo
 */
@Slf4j
@Validated
@RestController
public class TestController {
    
    @RequestMapping(value = "/test")
    public Object test(int type) {
        log.info("type: {}", type);
        
        return System.currentTimeMillis();
    }
    
    @RequestMapping(value = "/primary")
    public Object primary(@Min(value = 10, message = "最小10") int v) {
        log.info("primary --->>> : {}", v);
        
        return "primary";
    }
    
    @RequestMapping(value = "/user")
    public Object user(@Valid User user) {
        log.info("user --->>> : {}", JacksonJsonMapper.INSTANCE.toJson(user));
        
        return "user";
    }
    
    @RequestMapping(value = "/department")
    public Object department(@Valid @RequestBody Department department) {
        log.info("department --->>> : {}", JacksonJsonMapper.INSTANCE.toJson(department));
        
        return "department";
    }
}