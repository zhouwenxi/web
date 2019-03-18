package com.qishui.common;

import com.qishui.utils.LogUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qishui
 * @description
 * @date 2019/3/18 16:30
 * @Emial qishuichixi@163.com
 */
@Controller
public class ErrorPageAction {

    @RequestMapping(value = "/error404Page")
    public String error400Page() {
        LogUtils.e("访问404页面");
        return "404";
    }

    @RequestMapping(value = "/error500Page")
    public String error500Page() {
        LogUtils.e("访问500页面");
        return "500";
    }
}
