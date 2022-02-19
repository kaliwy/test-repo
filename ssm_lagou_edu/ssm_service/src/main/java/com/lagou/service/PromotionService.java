package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionSpace;
import com.lagou.domain.PromotionVO;

import java.util.List;

public interface PromotionService {
    public PageInfo findAllPromotion(PromotionVO promotionVO);
    public PromotionSpace findPromotionSpaceById(int id);
}
