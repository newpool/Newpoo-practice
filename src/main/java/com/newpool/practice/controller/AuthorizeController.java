package com.newpool.practice.controller;

import com.newpool.practice.dto.AccessTokenDTO;
import com.newpool.practice.dto.GithubUser;
import com.newpool.practice.mapper.UserMapper;
import com.newpool.practice.model.User;
import com.newpool.practice.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @program: practice
 * @description:
 * @author: zp
 * @create: 2020-09-03 14:46
 **/
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.url}")
    private String redirectUrl;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response) {

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_url(redirectUrl);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (githubUser != null) {
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmCreate(System.currentTimeMillis());
            user.setGmModified(user.getGmCreate());
            user.setAvatarUrl(githubUser.getAvatarUrl());
            userMapper.insertUser(user);
            response.addCookie(new Cookie("token", user.getToken()));
            /*request.getSession().setAttribute("githubUser",githubUser);*/
            //登陆成功记录cookie 和 session
        } else {
            //登陆失败，重新登陆
        }
        return "redirect:/";
    }
}
