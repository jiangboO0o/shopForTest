package com.javaweb.shop.dao;

import com.github.pagehelper.PageInfo;
import com.javaweb.shop.entity.Goods;

import java.util.List;

/**
 * @program: shop
 * @description: 商品信息
 * @author: LongJiangBo
 * @create: 2019-05-28 14:24
 **/
public interface GoodsMapper {
    //增
    int insert(Goods goods);
    //删
    int deleteByPrimaryKey(Integer id);
    //改
    int updateByPrimartKey(Goods goods);
    //查(分页)
    List<Goods> selectPage(Goods goods);
}
