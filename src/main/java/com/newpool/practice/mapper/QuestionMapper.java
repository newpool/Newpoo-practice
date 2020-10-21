package com.newpool.practice.mapper;

import com.newpool.practice.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    @Select("select * from question  LIMIT #{pageIndex},#{size}")
    List<Question> selectList(@Param(value = "pageIndex") Integer pageIndex,@Param(value = "size") Integer size);

    @Select("select count(1) from question")
    Integer selectCount();

}
