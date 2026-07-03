package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image

@Composable
fun GuessNumberScreen() {
    val targetNumber = remember { (0..100).random() }
    var userInput by remember { mutableStateOf("") }
    var resultMessage by remember { mutableStateOf("") }
    var isGuessed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (isGuessed) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
        } else {
            Text(text = resultMessage)
        }

        TextField(
            value = userInput,
            onValueChange = { newInput -> userInput = newInput },
            label = { Text("Введите число") }
        )

        Button(onClick = {
            val numero = userInput.toIntOrNull()
            if (numero != null) {
                when {
                    numero < targetNumber -> {
                        resultMessage = "Введенное число меньше загаданного"
                        isGuessed = false
                    }
                    numero > targetNumber -> {
                        resultMessage = "Введенное число больше загаданного"
                        isGuessed = false
                    }
                    else -> {
                        isGuessed = true
                    }
                }
            }
        }) {
            Text("Проверить")
        }
    }
}