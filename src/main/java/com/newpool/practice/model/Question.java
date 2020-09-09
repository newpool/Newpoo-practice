package com.newpool.practice.model;

import lombok.Data;

/**
 * @program: practice
 * @description:
 * @author: zp
 * @create: 2020-09-09 11:46
 **/
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
