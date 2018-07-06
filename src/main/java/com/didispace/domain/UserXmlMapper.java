package com.didispace.domain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserXmlMapper {
    User insertSelective(User user);

    List<User> findByName(@Param("name") String name);



    List<User> queryByName(String name);


    int insert(@Param("name") String name, @Param("age") Integer age);

    int deleteByNameAndAge(@Param("name") String name, @Param("age") Integer age);


}