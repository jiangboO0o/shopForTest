package com.javaweb.shop.controller.upload;

import com.javaweb.shop.common.HttpRequest;
import com.javaweb.shop.common.HttpResponse;
import com.javaweb.shop.utils.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: shop
 * @description: 文件上传到本地
 * @author: LongJiangBo
 * @create: 2019-06-20 14:08
 **/
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadFile uploadFile;
    /**
     * 文件批量上传
     * @param file
     * @return
     */
    @RequestMapping("/local/list")//请求路径
    public HttpResponse upload(@RequestBody MultipartFile[] file) {
        System.out.println(file);
        List list = new ArrayList();
        for (MultipartFile multipartFile:file){
            String url = uploadFile.uploadFileToLocal(multipartFile);
            if ("false".equals(url)){
                return HttpResponse.error("2001","上传失败");
            }
            list.add(url);
        }
        System.out.println("图片上传");
        System.out.println(list);
        return HttpResponse.success(list);
    }

    /**
     * 文件上传
     * @param file
     * @return
     */
    @RequestMapping("/local/one")//url请求路径
    public HttpResponse upload(@RequestBody MultipartFile file) {
        //File.separator是自动按照系统加载的文件夹分隔符/\,针对Windows和Linux分隔符不同的问题
        System.out.println(file);
        String url = uploadFile.uploadFileToLocal(file);
        if ("false".equals(url)){
            return HttpResponse.error("2001","上传失败");
        }
        System.out.println("图片上传");
        return HttpResponse.success(url);
    }

}
