package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        analyzeIntList(listOf(67, -14, 22, -8, 15))
        checkPasswordStrength("someTestPassword")
        setContent {
            MyApplicationTheme {
                GuessNumberScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}
fun analyzeIntList(input: List<Int>) {
    val minimo = input.min()
    val maximo = input.max()
    val suma = input.sum()
    val pares = input.count { it % 2 == 0 }
    val impares = input.count { it % 2 != 0 }

    println("Минимальное: $minimo")
    println("Максимальное: $maximo")
    println("Сумма: $suma")
    println("Четных: $pares")
    println("Нечетных: $impares")
}

fun checkPasswordStrength(password: String) {
    var condiciones = 0

    if (password.length >= 8) condiciones++
    if (password.any { it.isDigit() }) condiciones++
    if (password.any { it.isUpperCase() }) condiciones++
    if (password.any { it.isLowerCase() }) condiciones++
    if (password.any { !it.isLetterOrDigit() }) condiciones++

    val resultado = when {
        condiciones == 5 -> "надежный"
        condiciones == 4 -> "хороший"
        condiciones in 2..3 -> "средний"
        else -> "ненадежный"
    }

    println("Надежность пароля: $resultado")
}