package com.soz.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 博文页面,增加论坛功能
 * @author kingkiller
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @PostMapping("/getBlog")
    public JSONObject getBlog(){
        return new JSONObject();
    }


}
