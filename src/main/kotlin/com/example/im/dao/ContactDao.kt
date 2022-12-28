package com.example.im.dao

import com.example.im.bean.Friend
import com.example.im.bean.User
import org.apache.ibatis.annotations.Insert
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
    fun selectFriends(id:Int):List<User>

    @Insert("insert into Friend (id, friendId) values (#{id}, #{fid})")
    fun insertFriends(id: Int, fid: Int): Int

    @Select("select * from Friend where id=#{id} and friendId=#{friendId}")
    fun selectByIdAndFriendId(id:Int,friendId:Int):Friend?

}