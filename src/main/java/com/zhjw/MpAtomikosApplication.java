package com.zhjw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import java.util.TimeZone;

/**
 * Copyright (c) 2020-2024 All Rights Reserved.
 *
 * 应用启动类
 * @author zhjw
 * @date 2020-12-24 14:15:49
 * @version 1.0
 */
@SpringBootApplication
@EnableTransactionManagement
public class MpAtomikosApplication {

    /**
     * 应用启动入口
     *
     * @param args 入参
     */
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(MpAtomikosApplication.class, args);
    }

}
