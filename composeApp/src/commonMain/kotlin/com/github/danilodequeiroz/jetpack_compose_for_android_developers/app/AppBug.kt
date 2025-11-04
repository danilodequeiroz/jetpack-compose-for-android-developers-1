package com.github.danilodequeiroz.jetpack_compose_for_android_developers.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.danilodequeiroz.jetpack_compose_for_android_developers.main.a_essentials.ListWithBug
import com.github.danilodequeiroz.jetpack_compose_for_android_developers.ui.theme.BasicsCodelabTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun AppBug() {
    BasicsCodelabTheme {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            BugDemonstrator()
        }
    }
}

@Composable
fun BugDemonstrator() {
    var trigger by remember { mutableStateOf(0) }

    val myList = listOf("A", "B", "C")

    Column {
        ListWithBug(itemList = myList)
        ListWithBug(itemList = myList)
        ListWithBug(itemList = myList)

        Button(onClick = {
             trigger = trigger + 1
        }) {
            Text("Recompor a Lista")
        }

        Text("Trigger State: $trigger")
    }
}
