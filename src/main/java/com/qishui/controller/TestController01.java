package com.qishui.controller;

import com.qishui.bean.HttpBean;
import com.qishui.constant.Keys;
import com.qishui.bean.UserBean;
import com.qishui.utils.LogUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by zhou on 2019/1/26.
 * RestController 用于返回数据
 */
@RestController
@RequestMapping("/app")
public class TestController01 {

    //访问路径  http://localhost:8888/web/app
    @RequestMapping("/")
    private String index() {
        LogUtils.e("返回字符串...");
        return "Hello Spring Boot";
    }

    //访问路径  http://localhost:8888/web/app/user/getUserMessage
    @RequestMapping("/user/getUserMessage")
    public HttpBean getUser() {
        LogUtils.e("返回json对象...");
        HttpBean<UserBean> httpBean = new HttpBean<>();
        httpBean.setCode(Keys.SUCCESS);
        httpBean.setMessage("响应成功!");
        httpBean.setData(new UserBean(1, "qishui", "123456"));
        return httpBean;
    }

    //访问路径  http://localhost:8888/web/app/user/getUserListMessage
    @RequestMapping("/user/getUserListMessage")
    public HttpBean getUserList() {
        LogUtils.e("返回json对象列表...");
        ArrayList<UserBean> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new UserBean(i, "qishui" + i, "123456" + i + i));
        }
        HttpBean<ArrayList<UserBean>> httpBean = new HttpBean<>();
        httpBean.setCode(Keys.ERROR);
        httpBean.setMessage("响应失败!");
        httpBean.setData(list);

        return httpBean;
    }

}
