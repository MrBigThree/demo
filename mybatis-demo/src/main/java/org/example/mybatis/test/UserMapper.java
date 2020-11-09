package org.example.mybatis.test;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

public interface UserMapper {

    HashMap findUserById(@Param("id") Integer id);
}
