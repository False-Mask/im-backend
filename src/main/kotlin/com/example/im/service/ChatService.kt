package com.example.im.service

import com.example.im.bean.Chat
import com.example.im.dao.ChatDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *@author ZhiQiang Tu
 *@time 2022/12/29  13:42
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */

@Service
class ChatService {

    @Autowired
    private lateinit var dao: ChatDao

    fun getChat(from: String, to: String): List<Chat> {
        return dao.getChat(from, to)
    }


}