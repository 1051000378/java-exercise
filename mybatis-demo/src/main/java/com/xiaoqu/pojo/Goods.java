package com.xiaoqu.pojo;

public class Goods {

    private Integer goodsId;
    private String title;
    private String subTitle;
    private Float originalCost;
    private Float currentPrice;
    private Float discount;
    private Integer isFreeDelivery;
    private Integer categoryId;

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", originalCost=" + originalCost +
                ", currentPrice=" + currentPrice +
                ", discount=" + discount +
                ", isFreeDelivery=" + isFreeDelivery +
                ", categoryId=" + categoryId +
                '}';
    }
}
