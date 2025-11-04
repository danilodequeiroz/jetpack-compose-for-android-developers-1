package com.github.danilodequeiroz.jetpack_compose_for_android_developers.ui.screen

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.github.danilodequeiroz.jetpack_compose_for_android_developers.BasicsCodelabTheme
import jetpackcomposeforandroiddevelopers.composeapp.generated.resources.Res
import jetpackcomposeforandroiddevelopers.composeapp.generated.resources.show_less
import jetpackcomposeforandroiddevelopers.composeapp.generated.resources.show_more
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
@Composable
fun GreetingsScreen(
    items: List<String> = List(size = 1000) { "$it" }
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            contentPadding = WindowInsets.statusBars.asPaddingValues()
        ) {
            item {
                GreetingContent("Header")
            }
            items(items){ i->
                GreetingCard(name = i)
            }
        }
    }
}

@Composable
fun GreetingCard(
    modifier: Modifier = Modifier,
    name: String
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        GreetingContent(name = name)
    }
}

@Composable
fun GreetingContent(name: String) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val valueInDP = if (expanded) 48.dp else 0.dp

    val tweenExtraPadding by animateDpAsState(
        targetValue = valueInDP,
        animationSpec = tween(
            durationMillis = 2000
        )
    )

    val springExtraPadding by animateDpAsState(
        targetValue = valueInDP,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(
            vertical = 4.dp,
            horizontal = 8.dp,
        )
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier.padding(24.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .weight(weight = 1f)
                    .padding(bottom = springExtraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello,")
                Text(
                    text = name,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (expanded) {
                        stringResource( Res.string.show_less)
                    } else {
                        stringResource( Res.string.show_more)
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, widthDp = 320)
fun GreetingCard_Preview(){
    BasicsCodelabTheme {
        Column {
            GreetingCard(
                name ="Android"
            )
        }
    }
}

@Composable
@Preview(showBackground = true, widthDp = 320)
fun GreetingsScren_Preview_Light() {
    BasicsCodelabTheme {
        GreetingsScreen()
    }
}
