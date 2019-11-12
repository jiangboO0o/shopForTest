package com.javaweb.shop.common;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @program: shop
 * @description: 请求返回值
 * @author: LongJiangBo
 * @create: 2019-05-28 14:28
 **/
@Data
public final class ShopHttpResponse<T> implements Serializable {

    private static final long serialVersionUID = 19981212L;

    /**
     * code状态码，和状态唯一对映
     */
    private String code;

    /**
     * msg提示状态，即成功，失败等状态提示
     */
    private String msg;

    /**
     * 时间戳
     */
    private String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    /**
     * 结果
     */
    private T result;

    /**
     * 构造方法
     */
    private ShopHttpResponse(){}

    public ShopHttpResponse(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public ShopHttpResponse(String code, String msg, T result){
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public static <T> ShopHttpResponse success() {
        return new ShopHttpResponse(RetCode.SUCCESS.getCode(),RetCode.SUCCESS.getMsg());
    }

    public static <T> ShopHttpResponse success(T result) {
        return new ShopHttpResponse(RetCode.SUCCESS.getCode(),RetCode.SUCCESS.getMsg(),result);
    }

    public static <T> ShopHttpResponse<T> error(String code, String msg){
        return new ShopHttpResponse(code,msg);
    }

    public static <T> ShopHttpResponse<T> error(RetCode retCode){
        return new ShopHttpResponse();
    }
}
