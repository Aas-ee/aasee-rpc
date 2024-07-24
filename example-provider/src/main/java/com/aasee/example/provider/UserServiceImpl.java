package com.aasee.example.provider;

import com.aasee.example.common.model.User;
import com.aasee.example.common.service.UserService;

/**
 * 用户服务实现类
 */
public class UserServiceImpl implements UserService {
    /**
     * 获取用户
     *
     * @param user
     * @return
     */
    @Override
    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
