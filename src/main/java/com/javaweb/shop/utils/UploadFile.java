package com.javaweb.shop.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

/**
 * @program: shop
 * @description: 文件上传的方法
 * @author: LongJiangBo
 * @create: 2019-06-20 14:19
 **/
@Service
public class UploadFile {
    @Autowired
    private HttpServletRequest request;
    public String uploadFileToLocal(MultipartFile picture) {
        //获取文件在服务器的储存位置
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File filePath = new File(path);
        System.out.println("文件的保存路径：" + path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }
        if (null != picture) {
            //获取原始文件名称(包含格式)
            String originalFileName = picture.getOriginalFilename();
            System.out.println("原始文件名称：" + originalFileName);

            //获取文件类型，以最后一个`.`为标识
            String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
            System.out.println("文件类型：" + type);
            //获取文件名称（不包含格式）
            String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

            //设置文件新名称: 当前时间+文件名称（不包含格式）
            //拼接字符串
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(LocalDateTime.now().getNano());
            stringBuilder.append(".");
            stringBuilder.append(type);
            String fileName = stringBuilder.toString();
            System.out.println("新文件名称：" + fileName);

            //在指定路径下创建一个文件
            File targetFile = new File(path, fileName);

            //将文件保存到服务器指定位置
            try {
                picture.transferTo(targetFile);
                System.out.println("上传成功");
                //将文件在服务器的存储路径返回
                return (path + File.separator + fileName);
            } catch (IOException e) {
                System.out.println("上传失败");
                e.printStackTrace();
                return "false";
            }
        }
        return "false";
    }
}
