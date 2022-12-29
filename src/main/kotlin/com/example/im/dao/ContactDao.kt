package com.example.im.dao

import com.example.im.bean.Contacts
import com.example.im.bean.Friend
import com.example.im.bean.Message
import com.example.im.bean.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

/**
 *@author ZhiQiang Tu
 *@time 2022/12/28  18:21
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */
@Repository
interface ContactDao {
    @Select("select * from User where id in (select friendId from Friend where id=#{id})")
    fun selectFriends(id: Int): List<User>

    @Insert("insert into Friend (id, friendId) values (#{id}, #{fid})")
    fun insertFriends(id: Int, fid: Int): Int

    @Select("select * from Friend where id=#{id} and friendId=#{friendId}")
    fun selectByIdAndFriendId(id: Int, friendId: Int): Friend?

    @Insert("insert into Msg (msgFrom, msgTo, time, content) values (#{msgFrom},#{msgTo},#{time},#{content})")
    fun insertMessage(message: Message): Int

    @Select(
        """
            with ChatMsg as (select friendId,name,sex,age,profile,content,time,Msg.id
                            from Friend as F
                                inner join UserInfo as Info
                                     on F.friendId = Info.uid
                                inner join Msg
                                     on msgFrom = F.id and msgTo = friendId or msgFrom = friendId and msgTo = F.id
                                where F.id = #{id}),
                LastMsg as (select friendId, max(time) as time, max(id) as id
                 from ChatMsg group by friendId)
select LastMsg.friendId, name, sex, age, profile, content, LastMsg.time
from ChatMsg
         inner join LastMsg
                    on ChatMsg.friendId = LastMsg.friendId and LastMsg.time = ChatMsg.time and ChatMsg.id = LastMsg.id;
        """
    )
    @Results(
        Result(property = "uid", column = "friendId"),
        Result(property = "lastMessage", column = "content"),
        Result(property = "lastTime", column = "time")
    )
    fun selectContacts(id: Int):List<Contacts>

}