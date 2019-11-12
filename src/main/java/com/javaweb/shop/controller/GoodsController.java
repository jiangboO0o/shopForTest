package com.javaweb.shop.controller;

import com.javaweb.shop.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: shop
 * @description: 商品信息
 * @author: LongJiangBo
 * @create: 2019-05-28 14:24
 **/
@RestController
@RequestMapping("goods")
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("find")
    pu
}
