package com.github.danilodequeiroz.jetpack_compose_for_android_developers

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.github.danilodequeiroz.jetpack_compose_for_android_developers.ui.theme.DarkColorPalette
import com.github.danilodequeiroz.jetpack_compose_for_android_developers.ui.theme.LightColorPalette
import platform.UIKit.UIDevice

class IOSPlatform : Platform {
    override val name: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()


@Composable
actual fun BasicsCodelabTheme(
    darkTheme: Boolean,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorPalette else LightColorPalette,
        typography = com.github.danilodequeiroz.jetpack_compose_for_android_developers.ui.theme.Typography,
        content = content
    )
}