package com.github.danilodequeiroz.jetpack_compose_for_android_developers

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.github.danilodequeiroz.jetpack_compose_for_android_developers.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp(){
    BasicsCodelabTheme {
        var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
        if(shouldShowOnboarding){
            OnboardingScreen(
                onContinueClick = {  shouldShowOnboarding = false }
            )
        }else{
            GreetingsScreen()
        }
    }
}


@Composable
@Preview(showBackground = true, widthDp = 320, uiMode = UI_MODE_NIGHT_YES)
fun MainActivity_Preview_Night() {
    MyApp()
}

@Composable
@Preview(showBackground = true, widthDp = 320, uiMode = Configuration.UI_MODE_NIGHT_NO)
fun MainActivity_Preview_Light() {
    MyApp()
}