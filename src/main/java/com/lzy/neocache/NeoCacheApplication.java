package com.lzy.neocache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 基于一致性hash的分布式缓存系统 启动类
 */
@SpringBootApplication
public class NeoCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(NeoCacheApplication.class, args);
    }
}
