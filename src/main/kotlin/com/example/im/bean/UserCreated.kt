package com.example.im.bean

import org.springframework.stereotype.Component

/**
 *@author ZhiQiang Tu
 *@time 2022/12/28  13:23
 *@signature 我将追寻并获取我想要的答案
 *@mail  2623036785@qq.com
 */
@Component
class UserCreated : Success<String>(200, "创建成功", data = "succeed")