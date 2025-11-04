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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.github.danilodequeiroz.jetpack_compose_for_android_developers.Greeting
import jetpackcomposeforandroiddevelopers.composeapp.generated.resources.Res
import jetpackcomposeforandroiddevelopers.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

object ComponentStateVariations {
    @Composable
    fun MainContentStateful(shouldShowContent: Boolean) {
        var showContent by remember { mutableStateOf(shouldShowContent) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
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

    @Composable
    fun MainContentWrongOrBadStateNoRemember(shouldShowContent: Boolean) {
        var showContent = shouldShowContent
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
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
fun MainContentBadState_WrongState_NoRemember_Preview() {
    ComponentStateVariations.MainContentWrongOrBadStateNoRemember(
        shouldShowContent = true
    )
}

@Composable
@Preview
fun MainContentStateful_Preview() {
    ComponentStateVariations.MainContentStateful(
        shouldShowContent = true
    )
}

@Composable
@Preview
fun MainContentStateless_Preview() {
    ComponentStateVariations.MainContentStateless(
        shouldShowContent = true,
        onClickCallback = {}
    )
}