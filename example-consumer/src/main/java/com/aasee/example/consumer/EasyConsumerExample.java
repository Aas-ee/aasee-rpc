package com.aasee.example.consumer;

import com.aasee.aaseerpc.proxy.ServiceProxyFactory;
import com.aasee.example.common.model.User;
import com.aasee.example.common.service.UserService;

/**
 * 简易服务消费者示例
 */
public class EasyConsumerExample {

    public static void main(String[] args) {
//        // todo 需要获取 UserService 的实现类对象
//        UserService userService = null;
//        User user = new User();
//        user.setName("Aasee");
//        // 调用
//        User newUser = userService.getUser(user);
//        if (newUser != null) {
//            System.out.println(newUser.getName());
//        } else {
//            System.out.println("user == null");
//        }
        // 静态代理
//        UserService userService = new UserServiceProxy();
        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("Aasee");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
        long number = userService.getNumber();
        System.out.println(number);
    }
}