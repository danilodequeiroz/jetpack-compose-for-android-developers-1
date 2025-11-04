package com.github.danilodequeiroz.jetpack_compose_for_android_developers

import androidx.compose.material3.ColorScheme
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
actual fun getPlatformSpecificColorScheme(
    dynamicColor: Boolean,
    darkTheme: Boolean
): ColorScheme =  if (darkTheme) DarkColorPalette else LightColorPalette

@Composable
actual fun EnableEdgeToEdgeGlobal() =Unit
