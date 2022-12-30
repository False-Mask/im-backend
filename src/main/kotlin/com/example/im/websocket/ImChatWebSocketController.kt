package com.example.im.websocket

import com.example.im.bean.IM
import com.example.im.bean.Info
import com.example.im.bean.Message
import com.example.im.bean.Sender
import com.example.im.dao.ChatDao
import com.example.im.dao.ContactDao
import com.example.im.dao.UserDao
import com.google.gson.Gson
import jakarta.websocket.OnClose
import jakarta.websocket.OnMessage
import jakarta.websocket.OnOpen
import jakarta.websocket.Session
import jakarta.websocket.server.PathParam
import jakarta.websocket.server.ServerEndpoint
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import java.util.concurrent.ConcurrentHashMap

/**
 *@author ZhiQiang Tu
 *@time 2022/12/29  15:42
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */

@Component
@ServerEndpoint("/socket/{uid}")
class ImChatWebSocketController {

    companion object {
        lateinit var chatDao: ChatDao

        lateinit var contactDao: ContactDao

        lateinit var userDao: UserDao

        private var gson: Gson = Gson()

        val map: MutableMap<String, Session> = ConcurrentHashMap<String, Session>()

    }

    @Autowired
    fun setChatDao(dao: ChatDao) {
        chatDao = dao
    }

    @Autowired
    fun setContactDao(dao: ContactDao) {
        contactDao = dao
    }

    @Autowired
    fun setUserDao(dao: UserDao) {
        userDao = dao
    }



    @OnOpen
    fun onOpen(s: Session, @PathParam("uid") uid: String) {
        map[uid] = s
    }


    /* 常规数据：
        {
            "msgFrom":1,
            "msgTo":1,
            "content":"希望你永远都笑的像一束阳光，你是我的阳光。",
        }
     */

    @OnMessage
    fun onMessage(msg: String) {
        //对msg进行解析,然后进行数据的插入
        val message: Message = gson.fromJson(msg, Message::class.java) as Message
        contactDao.insertMessage(message)

        //查找是那个user
        val user = userDao.selectInfoByUid(message.msgFrom)

        val im = IM()

        im.data = Info().apply {
            this.from = Sender(user.uid, user.userName, user.name, user.sex, user.age, user.profile)
            this.msg = message
        }

        //通过ws发送消息给对于的user
        val msgTo = message.msgTo.toString()
        //如果msgTo连接存在即向其发送一条ws消息
        map[msgTo]?.basicRemote?.sendText(
            gson.toJson(im, IM::class.java)
        )

    }

    @OnClose
    fun onClose(@PathParam("uid") uid: String) {
        //清空连接
        map.remove(uid)
    }

}