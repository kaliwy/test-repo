package com.lagou.controller;

import com.lagou.domain.PromotionVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.impl.PromotionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.lagou.controller
 * @description:
 * @author: 霂惷
 */
@RestController
@RequestMapping("/promotion")
public class PromotionController {
    @Autowired
    private PromotionServiceImpl promotionServiceImpl;
    @RequestMapping("/findAllPromotion")
    public ResponseResult findAllPromotion(PromotionVO promotionVO){
        System.out.println(promotionVO.getCurrentPage()+promotionVO.getPageSize());
        return new ResponseResult(true, 200, "获取成功", promotionServiceImpl.findAllPromotion(promotionVO));
    }
    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult findPromotionSpaceById(int id){
        return new ResponseResult(true, 200, "获取成功", promotionServiceImpl.findPromotionSpaceById(id));
    }
}
