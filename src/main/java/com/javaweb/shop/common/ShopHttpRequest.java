package com.javaweb.shop.common;

import lombok.Data;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: shop
 * @description: 请求传入值
 * @author: LongJiangBo
 * @create: 2019-05-28 14:29
 **/
@Data
public class ShopHttpRequest<T> {
    //分页信息，页码
    private Integer pageNum = 0;
    //分页信息，分页大小
    private Integer pageSize = 10;
    //实体类
    private T params;
    /**
     * 操作人idheadder x-custom-userId
     */
    private String customUserId;
    /**
     * 操作人名headder x-custom-name
     */
    private String customName;

    public void setData(T params) {
        this.params = params;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        this.customUserId = request.getHeader("x-custom-userId");
//        this.customName = request.getHeader("x-custom-name");
    }
}


