package com.newpool.practice.mapper;

import com.newpool.practice.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: practice
 * @description:
 * @author: zp
 * @create: 2020-09-07 14:13
 **/
@Mapper
public interface UserMapper {

    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified) value (#{accountId},#{name},#{token},#{gmCreate},#{gmModified})")
    void insertUser(User user);
}
