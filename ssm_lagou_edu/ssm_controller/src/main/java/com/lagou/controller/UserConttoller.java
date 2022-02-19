package com.lagou.controller;

import com.lagou.domain.ResponseResult;
import com.lagou.domain.User;
import com.lagou.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @program: com.lagou.controller
 * @description: 登录
 * @author: 霂惷
 */
@RestController
@RequestMapping("/user")
public class UserConttoller {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request){
        User login = userServiceImpl.login(user);
        if(login.getId()!=null){
            HttpSession session = request.getSession();
            session.setAttribute("id", login.getId());
            String checkNum = UUID.randomUUID().toString();
            session.setAttribute("checkNum", checkNum);
            Map<String, Object> hashMap = new HashMap();
            hashMap.put("user", login);
            hashMap.put("checkNum", checkNum);

            return new ResponseResult(true, 200, "登录成功", hashMap);
        }else{
            return new ResponseResult(true, 200, "登录失败", null);
        }
    }
}
