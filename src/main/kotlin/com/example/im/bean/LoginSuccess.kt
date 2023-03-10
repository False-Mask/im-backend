package com.example.im.bean

import org.springframework.stereotype.Component

/**
 *@author ZhiQiang Tu
 *@time 2022/12/28  14:11
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */
@Component
class LoginSuccess : Success<User>(200, "登陆成功", null)