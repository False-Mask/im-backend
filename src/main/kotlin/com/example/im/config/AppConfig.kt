package com.example.im.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.PropertySource

/**
 *@author ZhiQiang Tu
 *@time 2022/12/27  22:27
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */
@Configuration
//导入mybatis配置
@Import(MyBatisConfig::class, SpringMvcConfig::class)
//导入properties文件
@PropertySource("classpath:application.properties")
class AppConfig {


}