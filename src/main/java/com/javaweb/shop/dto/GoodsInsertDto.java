package com.javaweb.shop.dto;

import lombok.Data;


/**
 * @program: dto文件夹主要存放数据传输类，
 * 即：前端要求的类，对应前端的数据要求，有的时候前端的数据要求和数据库中标字段的差距很大，
 * 故使用数据传输类映射前端要求，entity实体类映射数据库表结构。实际使用中在controller包进行dto和entity的转化。
 * @description: 商品信息插入数据传输类
 * @author: LongJiangBo
 * @create: 2019-11-12 10:51
 **/
//这个注解可以替代set和get方法，类中元素都是私有类型，外界无法获取或者修改，set用来修改，get用来获取
@Data
public class GoodsInsertDto {
    //唯一编号
    private Long id;
    //商品id
    private String goodsId;
    //发布者id
    private String ownerId;
    //店铺id
    private String shopId;
    //状态（状态字段一般是必有的）
    private Integer goodsStatus;
}
