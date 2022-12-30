package com.example.im.bean

/**
 *@author ZhiQiang Tu
 *@time 2022/12/29  19:52
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */
class IM : Success<Info>()

data class Info(
    var msg: Message = Message(),
    var from: Sender = Sender(),
)

data class Sender(
    var uid: Int = 0,
    var userName: String = "",
    var name: String = "",
    var sex: String = "",
    var age: Int = -1,
    var profile: String = ""
)