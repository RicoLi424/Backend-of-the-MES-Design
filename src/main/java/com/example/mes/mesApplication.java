package com.example.mes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@MapperScan(basePackages = { "com.example.mes.process.Mapper", "com.example.mes.dataAnalysis.Mapper",
        "com.example.mes.quality.mapper","com.example.mes.plan.dao","com.example.mes.WorkshopStorage.mapper" })
public class mesApplication {

    public static void main(String[] args) {
        SpringApplication.run(mesApplication.class, args);
    }

}
