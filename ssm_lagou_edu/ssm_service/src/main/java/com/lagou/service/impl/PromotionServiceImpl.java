package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.PromotionMapper;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionSpace;
import com.lagou.domain.PromotionVO;
import com.lagou.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: com.lagou.service.impl
 * @description:
 * @author: 霂惷
 */
@Service
public class PromotionServiceImpl implements PromotionService {
    @Autowired
    private PromotionMapper promotionMapper;

    @Override
    public PageInfo findAllPromotion(PromotionVO promotionVO) {
        PageHelper.startPage(promotionVO.getCurrentPage(), promotionVO.getPageSize());
        List<PromotionAd> allPromotion = promotionMapper.findAllPromotion();
        PageInfo<PromotionAd> promotionAdPageInfo = new PageInfo<>(allPromotion);

        return promotionAdPageInfo;
    }

    @Override
    public PromotionSpace findPromotionSpaceById(int id) {
        return promotionMapper.findPromotionSpaceById(id);
    }

}
