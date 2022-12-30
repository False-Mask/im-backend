package com.example.im.config

import org.springframework.context.annotation.Bean
import org.springframework.web.socket.server.standard.ServerEndpointExporter

/**
 *@author ZhiQiang Tu
 *@time 2022/12/29  19:09
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */
class WebSocketConfig {

    @Bean
    fun exporter() = ServerEndpointExporter()

}