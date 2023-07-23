package com.wjw.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjw.mpdemo.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
//继承自 BaseMapper就可以不用自己实现常用的 增删改查方法了
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user")
    public List<User> find();

    @Insert("insert into user values(#{id}, #{username}, #{password}, #{age}, #{gender}, #{email})")
    public int insertUser(User user);

    @Delete("delete form user where id = #{id}")
    int delete(int id);

    @Select("select * from user where id = #{id}")
    User findById(int id);

    @Select("select * from user where username = #{username}")
    User findByUsername(String username);
    @Select("select * from user")
    List<User> getAll();

}
