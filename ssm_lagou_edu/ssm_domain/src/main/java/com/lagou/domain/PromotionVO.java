package com.lagou.domain;

/**
 * @program: com.lagou.domain
 * @description: 广告参数封装对象
 * @author: 霂惷
 */
public class PromotionVO {
    private Integer currentPage;
    private Integer pageSize;

    @Override
    public String toString() {
        return "PromotionVO{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
