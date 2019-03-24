package com.qishui.controller;

import com.qishui.utils.LogUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhou on 2019/3/23.
 */
@Controller
public class PageController {

    //跳转到功能列表
    @RequestMapping(value = "/hao123", method = RequestMethod.GET)
    public String login() {
        //跳转到 templates 目录下的 login.html
        LogUtils.e("访问hao123.html");
        return "hao123";
    }

    //跳转到上传水印页面
    @RequestMapping(value = "/water_photo_upload", method = RequestMethod.GET)
    public String upload() {
        //跳转到 templates 目录下的 water_photo_upload.html
        LogUtils.e("访问water_photo_upload.html");
        return "water_photo_upload";
    }


}
