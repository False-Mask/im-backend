package com.example.im

import com.example.im.config.AppConfig
import com.example.im.dao.IMDao
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.AnnotationConfigApplicationContext

@SpringBootApplication
class ImApplication {

}

fun main(args: Array<String>) {
    val s = AnnotationConfigApplicationContext(AppConfig::class.java)
    val bean = s.getBean(IMDao::class.java)
    println(bean.search())
//runApplication<ImApplication>(*args)
}
