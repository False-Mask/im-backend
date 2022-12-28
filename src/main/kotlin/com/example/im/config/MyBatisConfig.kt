package com.example.im.config

import com.alibaba.druid.pool.DruidDataSource
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.annotation.MapperScan
import org.mybatis.spring.mapper.MapperScannerConfigurer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.PropertySource
import javax.sql.DataSource

/**
 *@author ZhiQiang Tu
 *@time 2022/12/27  22:28
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */

@MapperScan("com.example.im.dao")
class MyBatisConfig {

    @Bean
    fun produceSqlSessionFactoryBean(
        dataSource: DataSource
    ): SqlSessionFactoryBean = SqlSessionFactoryBean().apply {
        setDataSource(dataSource)
    }

//    高版本已经不需要手动设置driver了,通过spi自动装入
//    @Value("\${jdbc.driver}")
//    private lateinit var driverName: String

    @Value("\${jdbc.url}")
    private lateinit var jdbcUrl: String

    @Value("\${jdbc.username}")
    private lateinit var userName: String

    @Value("\${jdbc.pwd}")
    private lateinit var pwd: String

    @Bean
    fun produceDataSource(): DataSource = DruidDataSource().apply {
        username = userName
        password = pwd
        url = jdbcUrl

    }

}