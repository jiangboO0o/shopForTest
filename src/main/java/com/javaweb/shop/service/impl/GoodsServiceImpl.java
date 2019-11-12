package com.javaweb.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaweb.shop.dao.GoodsMapper;
import com.javaweb.shop.entity.Goods;
import com.javaweb.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: service包下的impl包主要是编写service中接口的对应的实现类。
 * @description: 商品信息
 * @author: LongJiangBo
 * @create: 2019-05-28 14:26
 **/
//这个注解的主要作用是，这个类下的方法可以被调用到。不加找不到。具体的官方说法，百度。
@Service
public class GoodsServiceImpl {
    //这个注解的作用是接口注入，加了它才能找到这个接口
    @Autowired
    private GoodsMapper goodsMapper;
    //增
    private int insert(Goods goods){return goodsMapper.insert(goods);}
    //删
    private int deleteByPrimaryKey(Integer id){return goodsMapper.deleteByPrimaryKey(id);}
    //改
    private int updateByPrimaryKey(Goods goods){return goodsMapper.updateByPrimartKey(goods);}
    //查（分页）
    private PageInfo selectPage(Integer pageNum, Integer pageSize,Goods goods){
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> goodsList = goodsMapper.selectPage(goods);
        return new PageInfo(goodsList);
    }
}
