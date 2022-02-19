package com.lagou.controller;

import com.lagou.domain.User;
import com.lagou.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: com.lagou.controller
 * @description: 测试
 * @author: 霂惷
 */
@RestController
public class TestController {
    @Autowired
    private TestService testService;
    public List<User> findAll(){
        return testService.findAll();
    }
}
