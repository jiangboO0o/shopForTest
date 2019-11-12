package com.javaweb.shop.service;

import com.github.pagehelper.PageInfo;
import com.javaweb.shop.entity.Goods;

/**
 * @program: shop
 * @description: 商品信息
 * @author: LongJiangBo
 * @create: 2019-05-28 14:25
 **/
public interface GoodsService {
    //增
    int insert(Goods goods);
    //删
    int deleteByPrimaryKey(Integer id);
    //改
    int updateByPrimartKey(Goods goods);
    //查(分页)
    PageInfo selectPage(Integer pageNum,Integer pageSize,Goods goods);
}
