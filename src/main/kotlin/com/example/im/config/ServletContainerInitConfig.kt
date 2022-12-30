package com.example.im.config

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer

/**
 *@author ZhiQiang Tu
 *@time 2022/12/28  11:00
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */
class ServletContainerInitConfig : AbstractAnnotationConfigDispatcherServletInitializer() {
    override fun getServletMappings(): Array<String> = arrayOf("/")

    override fun getRootConfigClasses(): Array<Class<*>> = arrayOf(AppConfig::class.java)

    override fun getServletConfigClasses(): Array<Class<*>> =
        arrayOf(SpringMvcConfig::class.java)


}