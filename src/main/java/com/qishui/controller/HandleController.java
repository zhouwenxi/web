package com.qishui.controller;

import com.qishui.utils.FileUtils;
import com.qishui.utils.LogUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by zhou on 2019/3/23.
 */
@Controller
public class HandleController {

    @RequestMapping(value = "/handle_water", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("fileName") MultipartFile file, Model model) {

        if (file.isEmpty()) {
            return "fail";
        }

        String filename = file.getOriginalFilename();

        try {
            String path = ResourceUtils.getURL("classpath:").getPath();
            File upload = new File(path, "static/upload/");
            if (!upload.exists()) {
                upload.mkdirs();
            }

            path = upload.getAbsolutePath() + "\\" + filename;
            LogUtils.e("upload url:" + path);
            //保存文件
            FileUtils.copy(file, path);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        model.addAttribute("src", "/upload/" + filename);

        return "study/water";
    }


    @RequestMapping(value = "/handle_water2", method = RequestMethod.POST)
    public String uploadFile2(@RequestParam("textUrl") String url, Model model) {

        LogUtils.e("url:"+url);
        if (url.isEmpty()) {
            return "fail";
        }
        model.addAttribute("src", url);

        return "study/water";
    }

}
