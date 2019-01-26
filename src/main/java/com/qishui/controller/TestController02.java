package com.qishui.controller;

import com.qishui.utils.LogUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhou on 2019/1/26.
 * Controller  用于页面跳转
 */
@Controller
public class TestController02 {

    //跳转到登录页面
    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String login() {
        //跳转到 templates 目录下的 login.html
        LogUtils.e("访问login.html");
        return "login";
    }

    //跳转到上传文件的页面
    @RequestMapping(value = "/toUpload", method = RequestMethod.GET)
    public String upload() {
        //跳转到 templates 目录下的 upload.html
        LogUtils.e("upload.html");
        return "upload";
    }

}
