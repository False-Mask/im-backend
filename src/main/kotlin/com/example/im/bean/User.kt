package com.example.im.bean

/**
 *@author ZhiQiang Tu
 *@time 2022/12/28  10:17
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */
data class User(
    var uid: Int = 0,
    var userName: String = "",
    var pwd: String = "",
    var name: String = "",
    var sex: String = "",
    var age: Int = -1
)