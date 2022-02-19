package com.lagou.dao;

import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionSpace;

import java.util.List;

public interface PromotionMapper {
    public List<PromotionAd> findAllPromotion();
    public PromotionSpace findPromotionSpaceById(int id);
}
