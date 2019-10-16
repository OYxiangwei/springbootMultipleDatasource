package com.test.springboot.second;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        //设置Repository所在位置
        basePackages = {"com.test.springboot.second"},
        //设置entityManager工厂
        entityManagerFactoryRef = "entityManagerFactorySecond",
        //设置事务管理器
        transactionManagerRef = "transactionManagerSecond"
)
public class SecondDataSourceConfiguration {
    private final DataSource secondDataSource;
    @Autowired
    public SecondDataSourceConfiguration(@Qualifier("secondDataSource") DataSource secondDataSource) {
        this.secondDataSource = secondDataSource;
    }
    @Bean(name = "entityManagerFactorySecond")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecond(EntityManagerFactoryBuilder builder) {
        return builder
                //设置数据源
                .dataSource(secondDataSource)
                //设置entity的包路径
                .packages("com.test.springboot.second")
                .build();
    }
    @Bean(name = "transactionManagerSecond")
    public PlatformTransactionManager transactionManagerSecond(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactorySecond(builder).getObject());
    }
}
