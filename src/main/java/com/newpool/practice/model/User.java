package com.newpool.practice.model;

/**
 * @program: practice
 * @description:
 * @author: zp
 * @create: 2020-09-07 14:15
 **/
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmCreate;
    private Long gmModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGmCreate() {
        return gmCreate;
    }

    public void setGmCreate(Long gmCreate) {
        this.gmCreate = gmCreate;
    }

    public Long getGmModified() {
        return gmModified;
    }

    public void setGmModified(Long gmModified) {
        this.gmModified = gmModified;
    }
}
