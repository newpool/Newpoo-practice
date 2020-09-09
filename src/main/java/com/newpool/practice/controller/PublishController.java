package com.newpool.practice.controller;

import com.newpool.practice.mapper.QuestionMapper;
import com.newpool.practice.mapper.UserMapper;
import com.newpool.practice.model.Question;
import com.newpool.practice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: practice
 * @description:
 * @author: zp
 * @create: 2020-09-08 16:00
 **/
@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(Question question,
                            HttpServletRequest request,
                            Model model) {
        model.addAttribute("title",question.getTitle());
        model.addAttribute("description",question.getDescription());
        model.addAttribute("tag",question.getTag());

        if(question.getTitle()==null || question.getTitle() == ""){
            model.addAttribute("title","请输入标题");
            return "publish";
        }
        if(question.getDescription()==null || question.getDescription() == ""){
            model.addAttribute("description","请输入问题");
            return "publish";
        }
        if(question.getTag()==null || question.getTag() == ""){
            model.addAttribute("tag","请输入标签");
            return "publish";
        }

        User user = null;
        //获取页面cookie信息
        Cookie[] cookies = request.getCookies();
        //循环遍历得到token
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("token")){
                String token = cookie.getValue();
                //拿到token带入数据库查询得到当前登录用户信息
                 user = userMapper.findByToken(token);
                if (user!=null){
                    //将用户信息存入session给页面使用
                    request.getSession().setAttribute("githubUser",user);
                }
                break;
            }
        }
        if (user==null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified( question.getGmtCreate());
        questionMapper.create(question);
        return "redirect:/";
    }
}
