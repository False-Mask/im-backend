package com.example.im.service

import com.example.im.bean.Error
import com.example.im.bean.FriendAdded
import com.example.im.bean.Result
import com.example.im.bean.User
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

    fun selectFriends(id: Int): List<User> {
        return dao.selectFriends(id)
    }

    fun addFriend(id: Int, fid: Int): Result {
        if (dao.selectByIdAndFriendId(id, fid) != null) {
            return Error(code = 400, msg = "已经添加过该好友")
        }
        friendAdded.data = dao.insertFriends(id, fid)
        return friendAdded
    }

}