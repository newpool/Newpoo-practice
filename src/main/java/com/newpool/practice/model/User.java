package com.newpool.practice.model;

import lombok.Data;

/**
 * @program: practice
 * @description:
 * @author: zp
 * @create: 2020-09-07 14:15
 **/
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmCreate;
    private Long gmModified;
    private String avatarUrl;
}
