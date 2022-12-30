package com.example.im

import com.example.im.bean.Message
import com.example.im.bean.User
import com.example.im.service.ChatService
import com.example.im.service.ContactService
import com.example.im.service.UserService
import com.example.im.utils.md5
import com.example.im.utils.profiles
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.json.GsonJsonParser
import org.springframework.boot.test.context.SpringBootTest
import kotlin.random.Random

@SpringBootTest
class ImApplicationTests {

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var contactService: ContactService

    @Test
    fun generateUser() {

        for (i in 0..10) {
            userService.register(
                User(
                    userName = i.toString(),
                    pwd = md5(i.toString()),
                    name = i.toString(),
                    sex = "男",
                    age = i,
                    profile = profiles.random()
                )
            )
        }
    }

    @Test
    fun generateChat() {
        for (i in 0..200) {
            val random = Random(System.currentTimeMillis())
            val a = random.nextInt(0, 11)
            var b = random.nextInt(0, 11)
            while (a == b) {
                b = random.nextInt(0, 11)
            }
            contactService.addMessage(Message(msgFrom = a, msgTo = b, content = words.random()))
        }
    }


    @Test
    fun generateFriends() {

        for (i in 0..100) {
            val random = Random(System.currentTimeMillis())
            val a = random.nextInt(0, 11)
            var b = random.nextInt(0, 11)
            while (a == b) {
                b = random.nextInt(0, 11)
            }
            contactService.addFriend(a, b)

        }

    }

    @Test
    fun selectContacts() {
        val x = contactService.selectContacts(1)
        println(x)
        println("=========================================")
    }

    @Test
    fun wordGenerater() {
        val url = "https://sword.studio/go/aHR0cDovL2FwaS5oaXRva290by5jbg==?charset=utf-8&encode=json&c=d"

    }

    @Autowired
    private lateinit var chat: ChatService

    //测试chat的获取
    @Test
    fun testGetChat() {


    }

}
