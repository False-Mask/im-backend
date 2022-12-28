package com.example.im.utils

import java.security.MessageDigest

fun md5(str: String): String {
    val md = MessageDigest.getInstance("MD5")
    val data = md.digest(str.toByteArray())


    return toHex(data)

}

fun toHex(byteArray: ByteArray): String {
    val result = with(StringBuilder()) {
        byteArray.forEach {
            val hex = it.toInt() and (0xFF)
            val hexStr = Integer.toHexString(hex)
            if (hexStr.length == 1) {
                this.append("0").append(hexStr)
            } else {
                this.append(hexStr)
            }
        }
        this.toString()
    }
    //转成16进制后是32字节
    return result
}

fun main() {
    println(md5("1212"))
}