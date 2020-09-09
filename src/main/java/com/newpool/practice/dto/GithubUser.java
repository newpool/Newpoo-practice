package com.newpool.practice.dto;

import lombok.Data;

import javax.annotation.security.DenyAll;

/**
 * @program: practice
 * @description:
 * @author: zp
 * @create: 2020-09-03 16:59
 **/
@Data
public class GithubUser {
    private String name;
    private  Long id;
    private  String bio;
    private String avatarUrl;
}
