package com.example.im.controller

import com.example.im.bean.ChatResult
import com.example.im.service.ChatService
import org.apache.ibatis.annotations.Param
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 *@author ZhiQiang Tu
 *@time 2022/12/29  14:04
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */

@Controller
@RequestMapping("/chat")
class ChatController {

    @Autowired
    private lateinit var service: ChatService

    @Autowired
    private lateinit var chat: ChatResult

    //获取用户与用户的聊天记录
    @RequestMapping("/list")
    @ResponseBody
    fun list(
        @Param("from") from: String,
        @Param("to") to: String
    ): ChatResult {
        chat.data = service.getChat(from, to)
        return chat
    }

}