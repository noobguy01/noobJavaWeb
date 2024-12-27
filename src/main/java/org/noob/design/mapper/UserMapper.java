package org.noob.design.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.noob.design.pojo.User;

@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username} and password = #{password} ")
    User login(User user);
    @Insert("insert into  user values (null,#{username},#{password},#{username})")
    void  insert(User user);

    @Select("select *from user where username = #{username}")
    User findByUsername(String username);
}
