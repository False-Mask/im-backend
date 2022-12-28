package com.example.im.controller

import com.example.im.bean.Result
import com.example.im.bean.User
import com.example.im.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 *@author ZhiQiang Tu
 *@time 2022/12/28  10:56
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */
@Controller
@RequestMapping("/user")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @RequestMapping("/register")
    @ResponseBody
    fun register(user: User): Result {
        return userService.register(user)
    }

    @RequestMapping("/login")
    @ResponseBody
    fun login(user: User): Result {
        return userService.login(user)
    }

}