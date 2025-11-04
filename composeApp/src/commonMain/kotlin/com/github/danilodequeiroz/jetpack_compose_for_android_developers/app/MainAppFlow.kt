package com.github.danilodequeiroz.jetpack_compose_for_android_developers.app


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.github.danilodequeiroz.jetpack_compose_for_android_developers.ui.screen.GreetingsScreen
import com.github.danilodequeiroz.jetpack_compose_for_android_developers.ui.screen.OnboardingScreen
import com.github.danilodequeiroz.jetpack_compose_for_android_developers.ui.theme.BasicsCodelabTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MainAppFlow(shouldShowOnboarding:Boolean = true) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(shouldShowOnboarding) }
    if (shouldShowOnboarding) {
        OnboardingScreen(
            onContinueClick = { shouldShowOnboarding = false }
        )
    } else {
        GreetingsScreen()
    }
}

@Composable
@Preview(showBackground = true, widthDp = 320)
fun MainActivityGreetings_Preview_Light() {
    BasicsCodelabTheme {
        MainAppFlow(
            shouldShowOnboarding = false
        )
    }
}

@Composable
@Preview(showBackground = true, widthDp = 320)
fun MainActivityOnbobarding_Preview_Light() {
    BasicsCodelabTheme {
        MainAppFlow(
            shouldShowOnboarding = true
        )
    }
}

