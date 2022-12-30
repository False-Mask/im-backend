package com.example.im.dao

import com.example.im.bean.Chat
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

/**
 *@author ZhiQiang Tu
 *@time 2022/12/29  13:43
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */

@Repository
interface ChatDao {

    @Select(
        """
            select false as isSelf, profile, content as message, time as timeMills
from UserInfo
         inner join Msg
                    on msgFrom = #{to} and msgTo=#{from}
where uid = #{to}
union
select true as isSelf, profile, content as message, time as timeMills
from UserInfo
         inner join Msg
                    on msgFrom = #{from} and msgTo=#{to}
where uid =#{from}
        """
    )
    @Results(
        Result(column = "isSelf", property = "isSelfMessage")
    )
    fun getChat(from: String, to: String): List<Chat>


}