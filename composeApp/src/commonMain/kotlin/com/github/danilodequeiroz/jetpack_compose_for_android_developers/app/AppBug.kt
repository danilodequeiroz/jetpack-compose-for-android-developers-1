package com.github.danilodequeiroz.jetpack_compose_for_android_developers.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import com.github.danilodequeiroz.jetpack_compose_for_android_developers.main.a_essentials.ListWithBug
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun AppBug() {
    val blabla by remember { mutableStateOf(1) }
    MaterialTheme {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize() // Fills the entire screen
                .padding(16.dp) // Optional padding
        ) {
            BugDemonstrator()
        }
    }
}

@Composable
fun BugDemonstrator() {
    // 1. Variável de estado que aciona a recompôsição quando muda
    var trigger by remember { mutableStateOf(0) }

    // Lista de dados estável
    val myList = listOf("A", "B", "C")

    Column {
        // Exibe o componente com o bug.
        // Ele recompõe sempre que 'trigger' muda.
        ListWithBug(itemList = myList)
        ListWithBug(itemList = myList)
        ListWithBug(itemList = myList)

        // 2. Um botão que muda o estado 'trigger'
        Button(onClick = {
            // Faz o trigger mudar, forçando a ListWithBug a recompôr
            // mesmo que a lista 'myList' não tenha mudado.
            // *Aqui eu usaria um MutableState para incrementar, mas vamos manter o 'val' simples
            // para demonstração, mesmo que em produção 'trigger' fosse um 'var state by remember { mutableStateOf(0) }'
            // O importante é: se algo de fora muda, ListWithBug é chamada de novo.

            // Simulação: Forçar uma mudança de estado que causaria a recompôsição.
            // Na prática, você precisaria de um 'var trigger by remember { mutableStateOf(0) }'
            // e incrementá-lo aqui.
            // Exemplo de como forçar a mudança:
             trigger = trigger + 1
        }) {
            Text("Recompor a Lista")
        }

        Text("Trigger State: $trigger")
    }
}
