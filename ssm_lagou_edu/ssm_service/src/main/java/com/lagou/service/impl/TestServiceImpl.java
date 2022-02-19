package com.lagou.service.impl;

import com.lagou.dao.TestMapper;
import com.lagou.domain.User;
import com.lagou.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: com.lagou.service.impl
 * @description: 测试
 * @author: 霂惷
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    @Override
    public List<User> findAll() {
        return testMapper.findAll();
    }
}
