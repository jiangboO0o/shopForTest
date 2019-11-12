package com.javaweb.shop.entity;

import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;

/**
 * @program: entity文件夹主要用于存放实体类，每个类和数据库中的一个表结构相对应，一个元素对应一个字段
 * @description: 商品信息
 * @author: LongJiangBo
 * @create: 2019-05-28 14:25
 **/
@Data
public class Goods {
    //元素明明遵循驼峰命名法，不必和数据库一样，在xml中有这个类的元素和数据表字段名的映射设置
    /**
     * @Description:唯一编号
    */
    private Long id;
    //商品id
    private String goodsId;
    //发布者id
    private String ownerId;
    //店铺id
    private String shopId;

    //元素类型统一使用包装类，（基本类型会有默认值，不可以为null，null这个东西，java有个空指针报错，很头疼）
    // 即：Integer，String,Long,Float,Double,Character,Boolean,Byte。包装类一般有相应的数据处理方法都挺好用。
    /*基本类型  -> 对应包装类
     * byte     -> Byte
     * short    -> Short
     * int      -> Integer
     * long     -> Long
     * float    -> Float
     * double   -> Double
     * char     -> Character
     * boolean  -> Boolean
    */
    //状态（状态字段一般是必有的）
    private Integer goodsStatus;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //开始时间
    @Transient
    //这个注解下的元素不会映射数据库字段
    private String startDate;
    //结束时间
    @Transient
    private String endDate;
     }
