package com.demo.service;

import com.demo.entity.User;
import com.demo.entity.vo.MessageModel;
import com.demo.mapper.UserMapper;
import com.demo.util.GetSqlSession;
import com.demo.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * 业务逻辑
 */
public class UserService {
    /**
     * 用户登录
     * @param uname
     * @param uPassword
     * @return
     */
    public MessageModel userLogin(String uname, String uPassword) {
        MessageModel messageModel = new MessageModel();
        User u = new User();
        u.setUsername(uname);
        u.setPassword(uPassword);
        messageModel.setObject(u);
        //参数的非空判断
        if (StringUtil.isEmpty(uname) || StringUtil.isEmpty(uPassword)) {
            messageModel.setCode(0);
            messageModel.setMsg("用户名和密码不能为空!");

            return messageModel;
        }

        //调用dao层,通过用户名查询用户对象
        SqlSession session = GetSqlSession.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.queryUserByName(uname);

        if (user == null) {
            messageModel.setCode(0);
            messageModel.setMsg("用户不存在!");

            return messageModel;
        }

        //判断数据库查询到的密码是否与前台传来的密码相同
        if (!uPassword.equals(user.getPassword())) {
            messageModel.setCode(0);
            messageModel.setMsg("用户密码错误!");

            return messageModel;
        }
        messageModel.setObject(user);

        return messageModel;
    }
}
