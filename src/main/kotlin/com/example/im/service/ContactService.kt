package com.example.im.service

import com.example.im.bean.*
import com.example.im.dao.ContactDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *@author ZhiQiang Tu
 *@time 2022/12/28  19:00
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */
@Service
class ContactService {

    @Autowired
    private lateinit var dao: ContactDao

    @Autowired
    private lateinit var friendAdded: FriendAdded


    fun addFriend(id: Int, fid: Int): Result {
        if (dao.selectByIdAndFriendId(id, fid) != null) {
            return Error(code = 400, msg = "已经添加过该好友")
        }
        friendAdded.data = dao.insertFriends(id, fid)
        return friendAdded
    }

    fun addMessage(message: Message) {
        dao.insertMessage(message)
    }

    fun selectContacts(id:Int): List<Contacts> {
        return dao.selectContacts(id)
    }

}