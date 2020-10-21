package com.newpool.practice.dto;

import com.newpool.practice.model.User;
import lombok.Data;

/**
 * @program: practice
 * @description:
 * @author: zp
 * @create: 2020-09-27 14:48
 **/
@Data
public class QuestionDTO {
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
    private User user;
}
