package com.qishui.controller;

import com.qishui.constant.Keys;
import com.qishui.utils.FileUtils;
import com.qishui.utils.LogUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by zhou on 2019/1/26.
 * 文件上传
 */
@Controller
public class TestController03 {

    @RequestMapping(value = "fileUpload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("fileName") MultipartFile file) {

        if (file.isEmpty()) {
            return "fail";
        }

        String filename = file.getOriginalFilename();
        String path = FileUtils.getDir(Keys.KEY_WEB_UPLOAD_OTHER, filename);
        //保存文件
        FileUtils.copy(file, path);
        return "success:" + path;
    }

    @RequestMapping(value = "multifileUpload01", method = RequestMethod.POST)
    @ResponseBody
    public String multifileUpload(@RequestParam("fileName") List<MultipartFile> files) {
        save(files);
        return "success---multifileUpload01";
    }

    /**
     * 实现多文件上传
     */
    @RequestMapping(value = "multifileUpload02", method = RequestMethod.POST)
    @ResponseBody
    public String multifileUpload01(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("fileName");
        save(files);
        return "success---multifileUpload02";
    }

    /**
     * 保存文件
     *
     * @param files
     */
    private void save(List<MultipartFile> files) {
        for (MultipartFile file : files) {
            String filename = file.getOriginalFilename();
            String path = FileUtils.getDir(Keys.KEY_WEB_UPLOAD_PICTURE, filename);
            //保存文件
            FileUtils.copy(file, path);
        }

    }

    @RequestMapping("download")
    public void downLoad(HttpServletResponse response) {
        String filename = "xUtils3-master.zip";
        String filePath = "E:/git";
        File file = new File(filePath + "/" + filename);
        //判断文件父目录是否存在
        if (file.exists()) {
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" + filename);

            byte[] buffer = new byte[1024];
            //文件输入流
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            //输出流
            OutputStream os = null;
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            LogUtils.e("----------file download" + filename);
            FileUtils.close(bis, fis);
        } else {
            LogUtils.e("文件不存在!");
        }

    }

}
