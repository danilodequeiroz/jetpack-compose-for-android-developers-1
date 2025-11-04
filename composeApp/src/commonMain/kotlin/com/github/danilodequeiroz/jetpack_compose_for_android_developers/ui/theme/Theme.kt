package com.github.danilodequeiroz.jetpack_compose_for_android_developers.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.github.danilodequeiroz.jetpack_compose_for_android_developers.EnableEdgeToEdgeGlobal
import com.github.danilodequeiroz.jetpack_compose_for_android_developers.getPlatformSpecificColorScheme


@Composable
fun BasicsCodelabTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = getPlatformSpecificColorScheme(
        dynamicColor = dynamicColor,
        darkTheme = darkTheme
    )

    EnableEdgeToEdgeGlobal()

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}