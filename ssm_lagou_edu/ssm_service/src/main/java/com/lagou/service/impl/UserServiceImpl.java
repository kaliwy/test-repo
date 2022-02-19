package com.lagou.service.impl;

import com.lagou.dao.UserMapper;
import com.lagou.domain.User;
import com.lagou.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: com.lagou.service.impl
 * @description: 用户登录验证
 * @author: 霂惷
 */
@Service
public class UserServiceImpl {
    @Autowired
    private UserMapper userMapper;
    public User login(User user){
        String encodePassword = Md5.md5(user.getPassword(), "lagou");
        User login = userMapper.login(user);
        if(login.getPassword().equalsIgnoreCase(encodePassword)){
            return login;
        }
        return null;

    }
}
