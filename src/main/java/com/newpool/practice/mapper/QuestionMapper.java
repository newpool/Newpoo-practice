package com.newpool.practice.mapper;

import com.newpool.practice.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: practice
 * @description:
 * @author: zp
 * @create: 2020-09-08 16:44
 **/
@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,gmt_create,description,gmt_modified,creator,comment_count,view_count,like_count,tag) values (#{title},#{gmtCreate},#{description},#{gmtModified},#{creator},#{commentCount},#{viewCount},#{likeCount},#{tag})")
    void create(Question question);
}
