package com.qishui.controller;

import com.qishui.bean.UserBean;
import com.qishui.utils.LogUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by zhou on 2019/1/26.
 * RestController 用于返回数据
 *
 */
@RestController
public class TestController01 {

    @RequestMapping("/")
    private String index() {
        LogUtils.e("返回字符串...");
        return "Hello Spring Boot";
    }

    @RequestMapping("/user/getUserMessage")
    public UserBean getUser() {
        LogUtils.e("返回json对象...");
        return new UserBean(1, "qishui", "123456");
    }

    @RequestMapping("/user/getUserListMessage")
    public ArrayList<UserBean> getUserList() {
        LogUtils.e("返回json对象列表...");
        ArrayList<UserBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new UserBean(i, "qishui" + i, "123456" + i + i));
        }
        return list;
    }

}
