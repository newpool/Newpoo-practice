package com.newpool.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: practice
 * @description:
 * @author: zp
 * @create: 2020-09-01 14:53
 **/
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){return "index";}
}
