package com.github.danilodequeiroz.jetpack_compose_for_android_developers

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform