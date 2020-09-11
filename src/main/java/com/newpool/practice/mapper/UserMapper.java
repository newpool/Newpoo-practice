package com.newpool.practice.mapper;

import com.newpool.practice.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @program: practice
 * @description:
 * @author: zp
 * @create: 2020-09-07 14:13
 **/
@Mapper
public interface UserMapper {

    //插入用户信息
    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified,AVATAR_URL) value (#{accountId},#{name},#{token},#{gmCreate},#{gmModified}),#{avatarUrl}")
    void insertUser(User user);

    //根据token得到用户信息
    @Select("select * from user where token=#{token}")
    User findByToken(String token);
}
