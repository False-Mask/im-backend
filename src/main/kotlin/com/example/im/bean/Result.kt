package com.example.im.bean

/**
 *@author ZhiQiang Tu
 *@time 2022/12/28  12:39
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */
interface Result
open class Success<T>(
    val code: Int,
    val msg: String,
    val data: T? = null
) : Result

open class Error(
    val code: Int,
    val msg: String
) : Result