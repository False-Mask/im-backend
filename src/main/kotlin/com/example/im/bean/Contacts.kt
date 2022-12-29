package com.example.im.bean

/**
 *@author ZhiQiang Tu
 *@time 2022/12/28  21:58
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */
data class Contacts(
    var uid: Int = 0,
    var name: String = "",
    var sex: String = "",
    var age: Int = -1,
    var profile: String = "",
    var lastMessage: String = "",
    var lastTime: Long = -1,
)