package com.github.danilodequeiroz.jetpack_compose_for_android_developers.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.github.danilodequeiroz.jetpack_compose_for_android_developers.Greeting
import jetpackcomposeforandroiddevelopers.composeapp.generated.resources.Res
import jetpackcomposeforandroiddevelopers.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

object StateHoisting {

    @Composable
    fun MainContentStateful(shouldShowContent: Boolean) {
        var showContent by rememberSaveable { mutableStateOf(shouldShowContent) }

        MainContentStateless(
            shouldShowContent = showContent,
            onClickCallback = {
                showContent = showContent.not()
            }
        )
    }

    @Composable
    fun MainContentStateless(
        shouldShowContent: Boolean,
        onClickCallback: () -> Unit
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = onClickCallback) {
                Text("Click me!")
            }
            AnimatedVisibility(shouldShowContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}

@Composable
@Preview
fun StateHoistingMainContent_Preview() {
    StateHoisting.MainContentStateful(
        shouldShowContent = true
    )
}
