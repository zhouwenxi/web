package com.qishui.controller;

import com.qishui.constant.Keys;
import com.qishui.utils.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhou on 2019/1/26.
 * 文件上传
 */
@Controller
public class TestController03 {

    @RequestMapping("fileUpload")
    @ResponseBody
    public String uploadFile(@RequestParam("fileName") MultipartFile file) {

        if (file.isEmpty()) {
            return "fail";
        }

        String filename = file.getOriginalFilename();
        String path = FileUtils.getDir(Keys.KEY_WEB_UPLOAD_PICTURE, filename);
        try {
            file.transferTo(new File(path)); //保存文件
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
        return "success:" + path;
    }

    @RequestMapping("multifileUpload")
    @ResponseBody
    public String uploadFiles(@RequestParam("fileName") MultipartFile file) {

        if (file.isEmpty()) {
            return "fail222";
        }
        return "success222";
    }

}
