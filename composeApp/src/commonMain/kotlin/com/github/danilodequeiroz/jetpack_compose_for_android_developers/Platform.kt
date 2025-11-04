package com.github.danilodequeiroz.jetpack_compose_for_android_developers

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

@Composable
expect fun getPlatformSpecificColorScheme(
    dynamicColor: Boolean,
    darkTheme: Boolean
): ColorScheme

@Composable
expect fun EnableEdgeToEdgeGlobal()