package com.demo.test;

import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import com.demo.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

public class Test {
    public static void main(String[] args) {
        // 获取SqlSession对象
        SqlSession session = GetSqlSession.createSqlSession();
        // 得到对应的Mapper
        UserMapper userMapper = session.getMapper(UserMapper.class);
        // 调用方法返回用户对象
        User user = userMapper.queryUserByName("admin");
        System.out.println(user);
    }
}
