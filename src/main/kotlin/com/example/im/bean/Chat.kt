package com.example.im.bean

/**
 *@author ZhiQiang Tu
 *@time 2022/12/29  13:49
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */
data class Chat(
    val isSelfMessage: Boolean = false,
    val profile: String = "",
    val message: String = "",
    val timeMills: Long = -1,
)