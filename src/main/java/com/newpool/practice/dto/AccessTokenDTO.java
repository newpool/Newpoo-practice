package com.newpool.practice.dto;

import lombok.Data;

/**
 * @program: practice
 * @description:
 * @author: zp
 * @create: 2020-09-03 15:51
 **/
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;
    private String state;


}
