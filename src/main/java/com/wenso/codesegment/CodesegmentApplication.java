package com.wenso.codesegment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// 排除特定自动配置
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class CodesegmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodesegmentApplication.class, args);
    }

}
