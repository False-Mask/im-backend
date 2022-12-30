package com.example.im.controller

import com.example.im.bean.Contacts
import com.example.im.bean.ContactsResult
import com.example.im.bean.User
import com.example.im.dao.ContactDao
import com.example.im.service.ContactService
import org.apache.ibatis.annotations.Param
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 *@author ZhiQiang Tu
 *@time 2022/12/28  18:21
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */
@Controller
@RequestMapping("/contact")
class ContactController {

    @Autowired
    private lateinit var service: ContactService

    @Autowired
    private lateinit var contactsResult: ContactsResult


    //获取用户的好友列别
    @RequestMapping("/list")
    @ResponseBody
    fun searchContacts(@Param("id") id: Int): ContactsResult {
        contactsResult.data = service.selectContacts(id)
        return contactsResult
    }

}