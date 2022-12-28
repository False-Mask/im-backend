package com.example.im

import com.example.im.bean.User
import com.example.im.service.ContactService
import com.example.im.service.UserService
import com.example.im.utils.md5
import com.example.im.utils.profiles
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
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

        for(i in 0..10) {
            userService.register(User(
                userName = i.toString(),
                pwd = md5(i.toString()),
                name = i.toString(),
                sex = "男",
                age = i,
                profile = profiles.random()
            ))

        }
    }

    @Test
    fun generateChat() {
        contactService
    }


    @Test
    fun generateFriends() {

        for(i in 0..2000) {
            val random = Random(System.currentTimeMillis())
            val a = random.nextInt(0,11)
            val b = random.nextInt(0,11)
            if(a != b) {
                contactService.addFriend(a,b)
            }

        }

    }

}
