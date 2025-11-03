package com.github.danilodequeiroz.jetpack_compose_for_android_developers

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}