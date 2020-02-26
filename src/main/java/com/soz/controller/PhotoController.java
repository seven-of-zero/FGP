package com.soz.controller;

import com.soz.service.UserService;
import com.soz.utils.Constants;
import com.soz.utils.FileUtils;
import com.soz.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("photoupdate")
public class PhotoController {

    @Autowired
    private UserService userService;

    @RequestMapping("/recivePhoto")
    @ResponseBody
    public void recivePhoto(HttpServletRequest request, HttpServletResponse response, HttpSession session
            , @RequestParam("file") MultipartFile file){

        String path="";
        if (file!=null){
            try{
                if (!file.isEmpty()){
                    //上传文件,随机名称,";"分号隔开
                    path = FileUtils.uploadImage(request, "/upload/" + TimeUtil.formateString(new Date(), "yyyy-MM-dd") + "/", file, true);

                }
                //上传成功
                if (path!=null){
                    System.out.println("上传成功");
                    Constants.printJson(response,path);
                    String name = (String) session.getAttribute("name");
                    userService.addPhoto(path,name);
                }else {
                    Constants.printJson(response,"上传失败! 文件格式错误");
                }
            }catch (Exception e){
                e.printStackTrace();
                Constants.printJson(response,"上传出现异常");
            }
        }else{
            Constants.printJson(response,"没有检测到文件!");

        }

    }
}
