package com.aasee.example.provider;


import com.aasee.aaseerpc.RpcApplication;
import com.aasee.aaseerpc.config.RegistryConfig;
import com.aasee.aaseerpc.config.RpcConfig;
import com.aasee.aaseerpc.model.ServiceMetaInfo;
import com.aasee.aaseerpc.registry.LocalRegistry;
import com.aasee.aaseerpc.registry.Registry;
import com.aasee.aaseerpc.registry.RegistryFactory;
import com.aasee.aaseerpc.server.HttpServer;
import com.aasee.aaseerpc.server.VertxHttpServer;
import com.aasee.example.common.service.UserService;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {

        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
//        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
        // 注册服务
        String serviceName =UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig= RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}