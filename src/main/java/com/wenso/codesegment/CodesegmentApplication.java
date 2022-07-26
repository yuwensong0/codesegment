package com.wenso.codesegment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@MapperScan("com.wenso.codesegment.mybatisplus.mapper")
// 排除特定自动配置
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class CodesegmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodesegmentApplication.class, args);
    }

}
