package com.example.im.dao

import com.example.im.bean.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

/**
 *@author ZhiQiang Tu
 *@time 2022/12/28  11:18
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */
@Repository
interface UserDao {

    @Select("select * from User where id=#{id}")
    fun selectById(id: Int): User

    @Select("select * from User where userName=#{userName}")
    fun selectByUserName(userName: String): User?

    @Select("select * from UserInfo where uid=#{uid}")
    fun selectInfoByUid(uid: Int): User

    @Select("select * from User where userName=#{userName} and pwd=#{pwd}")
    fun selectByNameAndPwd(user: User): User?

    @Insert("insert into User (userName, pwd) values (#{userName},#{pwd})")
    fun insertUser(user: User)

    @Insert("insert into UserInfo (uid, name, sex, age, profile) " +
            "values (#{uid}, #{name}, #{sex}, #{age}, #{profile})")
    fun insertInfo(user: User)

}