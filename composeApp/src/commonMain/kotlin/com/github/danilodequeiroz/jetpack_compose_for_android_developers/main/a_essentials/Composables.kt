package com.github.danilodequeiroz.jetpack_compose_for_android_developers.main.a_essentials

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ListWithBug(itemList: List<String>) {
    var items = 0
    Row(
        Modifier.background(color = Color.Cyan),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            for (item in itemList) {
                Text("item: $item items qty: $items")
                items++
            }
            Text("Count $items")
        }
    }
}

@Composable
@Preview
fun ListWithBugs_Preview() {
    ListWithBug(
        itemList = listOf(
            "1111",
            "222",
            "333",
            "444",
            "555",
        )
    )
}