package com.example.im.service

import com.example.im.bean.*
import com.example.im.dao.UserDao
import com.example.im.utils.profiles
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *@author ZhiQiang Tu
 *@time 2022/12/28  11:17
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */
@Service
class UserService {

    @Autowired
    lateinit var dao: UserDao

    @Autowired
    lateinit var succeed: UserCreated

    @Autowired
    lateinit var loginSuccess: LoginSuccess

    fun registed(userName: String): Boolean {
        return dao.selectByUserName(userName) != null
    }

    fun register(user: User): Result {
        //判断用户名的合法性
        if (!user.userName.matches("[0-9]{1,10}".toRegex())) {
            return Error(code = 400, msg = "账号必须是1-10位的数字!!")
        }
        //密码校验
        if (!user.pwd.matches("[0-9a-f]{32}".toRegex())) {
            return Error(code = 400, msg = "密码必须是32位md5值!!")
        }
        //其他字段判别
        if (user.age < 0 || user.age > 100) {
            return Error(code = 400, msg = "年龄非法!!")
        }
        if (user.sex != "男" && user.sex != "女") {
            return Error(code = 400, msg = "性别非法!!")
        }
        //如果已经注册
        if (registed(user.userName)) {
            return Error(code = 400, msg = "该用户已经注册了!!")
        }
        //头像随机给一个
        user.profile = profiles.random()
        //注册
        dao.insertUser(user)
        val u = dao.selectByNameAndPwd(user)
        user.apply { uid = u!!.uid }
        dao.insertInfo(user)
        return succeed
    }


    fun login(user: User): Result {
        if (null == dao.selectByNameAndPwd(user)) {
            return Error(code = 400, msg = "用户名或密码错误")
        }
        val u = dao.selectByUserName(user.userName)!!
        val uinfo = dao.selectInfoByUid(u.uid)
        u.age = uinfo.age
        u.profile = uinfo.profile
        u.name = uinfo.name
        u.sex = uinfo.sex
        loginSuccess.data = u
        return loginSuccess
    }

}
