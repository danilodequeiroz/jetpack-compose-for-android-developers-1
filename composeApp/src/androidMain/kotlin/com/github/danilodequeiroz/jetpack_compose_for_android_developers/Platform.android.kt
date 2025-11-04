package com.github.danilodequeiroz.jetpack_compose_for_android_developers

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.Window
import android.view.WindowInsets
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import com.github.danilodequeiroz.jetpack_compose_for_android_developers.ui.theme.DarkColorPalette
import com.github.danilodequeiroz.jetpack_compose_for_android_developers.ui.theme.LightColorPalette

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()


@Composable
actual fun EnableEdgeToEdgeGlobal() {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window

            (view.context as ComponentActivity).enableEdgeToEdge(
                statusBarStyle = SystemBarStyle.light(
                    Color.TRANSPARENT,
                    Color.TRANSPARENT
                ),
                navigationBarStyle = SystemBarStyle.auto(
                    Color.TRANSPARENT,
                    Color.TRANSPARENT
                )
            )
        }
    }
}

@Composable
actual fun getPlatformSpecificColorScheme(
    dynamicColor: Boolean,
    darkTheme: Boolean
): ColorScheme {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorPalette
        else -> LightColorPalette
    }
    return colorScheme
}

fun setStatusBarColor(window: Window, color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) { // Android 15+
        window.decorView.setOnApplyWindowInsetsListener { view, insets ->
            val statusBarInsets = insets.getInsets(WindowInsets.Type.statusBars())
            view.setBackgroundColor(color)

            view.setPadding(0, statusBarInsets.top, 0, 0)
            insets
        }
    } else {
        window.setLegacyStatusBarColor(color = color)
    }
}

@Suppress("deprecation")
private fun Window.setLegacyStatusBarColor(color: Int) {
    this.statusBarColor = color
}