package com.github.danilodequeiroz.jetpack_compose_for_android_developers

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            Greetings()
        }
    }
}

@Composable
fun Greetings(
    modifier: Modifier = Modifier,
    items: List<String> = List(size = 1000) { "$it" }
) {
    Surface {
        LazyColumn {
            item {
                Greeting("Header")
            }
            items(items){ i->
                Greeting(i)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
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
                modifier = Modifier.weight(weight = 1f)
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
            ElevatedButton(
                onClick = {
                    expanded = expanded.not()
                }) {
                Text(
                    text = if (expanded) "Show less" else "Show more"
                )
            }
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