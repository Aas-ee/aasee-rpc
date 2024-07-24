package com.aasee.example.provider;


import com.aasee.aaseerpc.registry.LocalRegistry;
import com.aasee.aaseerpc.server.HttpServer;
import com.aasee.aaseerpc.server.VertxHttpServer;
import com.aasee.example.common.service.UserService;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8999);
    }
}