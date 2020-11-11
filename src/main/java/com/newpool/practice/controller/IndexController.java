package com.newpool.practice.controller;

import com.newpool.practice.dto.PaginationDTO;
import com.newpool.practice.dto.QuestionDTO;
import com.newpool.practice.mapper.UserMapper;
import com.newpool.practice.model.User;
import com.newpool.practice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: practice
 * @description:
 * @author: zp
 * @create: 2020-09-01 14:53
 **/
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    /**
     * @return java.lang.String
     * @Author zp
     * @Description //TODO 初始页面
     * @Date 10:23 2020/9/8
     * @Param [request]
     **/
    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model mdoel,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "2") Integer size) {
        /**
         * @Author zp
         *登录逻辑：
         * 1、调用Github接口获取用户信息
         * 2、将用户信息存库、存cookie返回页面
         * 3、传入关键信息token 查库是否有账号，将用户信息存入session返回页面
         * 4、登陆成功
         **/
        //获取页面cookie信息
        Cookie[] cookies = request.getCookies();
        //循环遍历得到token
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                //拿到token带入数据库查询得到当前登录用户信息
                User user = userMapper.findByToken(token);
                if (user != null) {
                    //将用户信息存入session给页面使用
                    request.getSession().setAttribute("githubUser", user);
                }
                break;
            }
        }
        //获取列表信息
        PaginationDTO paginationDTO = questionService.list(page,size);
        mdoel.addAttribute("paginations", paginationDTO);
        return "index";
    }


}

