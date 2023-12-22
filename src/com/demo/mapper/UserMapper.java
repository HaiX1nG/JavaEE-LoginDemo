package com.demo.mapper;

import com.demo.entity.User;

/**
 * 这是一个用户接口类
 */
public interface UserMapper {
    public User queryUserByName(String username);

}
