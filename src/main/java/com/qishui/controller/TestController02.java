package com.qishui.controller;

import com.qishui.bean.HttpBean;
import com.qishui.bean.UserBean;
import com.qishui.constant.Keys;
import com.qishui.utils.FileUtils;
import com.qishui.utils.LogUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;

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


    @RequestMapping(value = "/userAccount/login.action", method = RequestMethod.POST)
    public String toMain() {
        //跳转到 templates 目录下的 mian.html
        LogUtils.e("mian.html");
        return "mian";
    }


    /**
     * @param map
     * @return
     */
    @RequestMapping("/index")
    public String helloHtml(HashMap<String, Object> map, Model model) {
        model.addAttribute("say", "欢迎欢迎,热烈欢迎");
        map.put("hello", "欢迎进入HTML页面");


        ArrayList<UserBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new UserBean(i, "qishui" + i, "123456" + i + i));
        }
        HttpBean<ArrayList<UserBean>> httpBean = new HttpBean<>();
        httpBean.setCode(Keys.SUCCESS);
        httpBean.setMessage("响应成功!");
        httpBean.setData(list);

        model.addAttribute("list", list);


        return "index";
    }


    //跳转到上传文件的页面
    @RequestMapping(value = "/toUpload", method = RequestMethod.GET)
    public String upload() {
        //跳转到 templates 目录下的 upload.html
        LogUtils.e("upload.html");
        return "upload";
    }




}
