package com.didispace.domain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserXmlMapper {
    User insert(User user);

    User findByName(@Param("name") String name);

    List<User> queryByName(String name);


    int insert(@Param("name") String name, @Param("age") Integer age);

}