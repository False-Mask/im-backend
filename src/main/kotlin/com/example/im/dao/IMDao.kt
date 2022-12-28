package com.example.im.dao

import com.example.im.bean.User
import org.apache.ibatis.annotations.Select

/**
 *@author ZhiQiang Tu
 *@time 2022/12/28  10:15
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */
interface IMDao {
    @Select("select * from User")
    fun search():List<User>

}

