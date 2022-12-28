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

//头像地址,这里直接采用random，时间原因，没时间本地存储了。懒
val profiles = arrayOf(
    "https://dogefs.s3.ladydaily.com/~/source/unsplash/photo-1672141363184-2626a3ae3916?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwzfHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=500&q=80",
    "https://dogefs.s3.ladydaily.com/~/source/unsplash/photo-1672218814630-97eb18814965?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw0fHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=500&q=80",
    "https://dogefs.s3.ladydaily.com/~/source/unsplash/photo-1664575196044-195f135295df?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHw2fHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=500&q=80",
    "https://dogefs.s3.ladydaily.com/~/source/unsplash/photo-1672169438836-0bde035ae8a9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw4fHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=500&q=80",
    "https://dogefs.s3.ladydaily.com/~/source/unsplash/photo-1672167630747-35dd70a83994?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxNXx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=80",
    "https://plus.unsplash.com/premium_photo-1669562732451-e37bc19bf6bf?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxM3x8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=80",
    "https://dogefs.s3.ladydaily.com/~/source/unsplash/photo-1672197339956-b7c8f8fed5cd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxN3x8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=80",
    "https://dogefs.s3.ladydaily.com/~/source/unsplash/photo-1672162723231-a03172f2d8d9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwyM3x8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=80",
    "https://dogefs.s3.ladydaily.com/~/source/unsplash/photo-1664575195621-a5f347e67554?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwyNnx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=80",
    "https://dogefs.s3.ladydaily.com/~/source/unsplash/photo-1664574654529-b60630f33fdb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwyN3x8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=80",
    "https://dogefs.s3.ladydaily.com/~/source/unsplash/photo-1670844763152-81c99a307cf4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwzNHx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=80",
    "https://dogefs.s3.ladydaily.com/~/source/unsplash/photo-1672107097540-897c4a8440ea?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwzN3x8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=80",
    "https://dogefs.s3.ladydaily.com/~/source/unsplash/photo-1672108654202-9f632dc907fe?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwzOXx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=80",
    "https://dogefs.s3.ladydaily.com/~/source/unsplash/photo-1670349081674-90d0e76a20ad?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHw0Nnx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=80",
    "https://dogefs.s3.ladydaily.com/~/source/unsplash/photo-1671952988057-aa2b81dca28a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw1M3x8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=80",
    "https://dogefs.s3.ladydaily.com/~/source/unsplash/photo-1672151185451-cfe0f176a803?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw1OXx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=80",
    "https://dogefs.s3.ladydaily.com/~/source/unsplash/photo-1672152024595-d8f2ec9dbdeb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw2NXx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=80"
)