package com.aasee.example.consumer;

import com.aasee.aaseerpc.config.RpcConfig;
import com.aasee.aaseerpc.utils.ConfigUtils;

/**
 * 简易服务消费者示例
 *
 */
public class ConsumerExample {

    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);
    }
}
