package com.javaweb.shop.controller;

import com.github.pagehelper.PageInfo;
import com.javaweb.shop.common.ShopHttpRequest;
import com.javaweb.shop.common.ShopHttpResponse;
import com.javaweb.shop.entity.Goods;
import com.javaweb.shop.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: shop
 * @description: 商品信息
 * @author: LongJiangBo
 * @create: 2019-05-28 14:24
 **/
//这两个注解Controller必须有
@RestController
@RequestMapping("goods")
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    //有了这个注解，才能调用该接口下的方法
    @Autowired
    private GoodsService goodsService;

    //这个注解后面扩号里面写的是路由，一级一级的拼起来就是url
    @RequestMapping("/add")
    public ShopHttpResponse goodsAdd(@RequestBody Goods goods){
        logger.info("新增商品信息，参数={}",goods);
        goodsService.insert(goods);
        return ShopHttpResponse.success();
    }

    @RequestMapping("/page")
    public ShopHttpResponse goodsPage(@RequestBody ShopHttpRequest<Goods> shopHttpRequest){
        logger.info("商品信息分页查询，参数={}",shopHttpRequest);
        //声明新的商品对象
        Goods goods = new Goods();
        //判空，防止报空指针的错误
        if (null != shopHttpRequest){
            //获取参数
            goods = shopHttpRequest.getParams();
        }
        PageInfo<Goods> pageInfoGoods = goodsService.selectPage(shopHttpRequest.getPageNum(),shopHttpRequest.getPageSize(),goods);
        return ShopHttpResponse.success(pageInfoGoods);
    }
}
