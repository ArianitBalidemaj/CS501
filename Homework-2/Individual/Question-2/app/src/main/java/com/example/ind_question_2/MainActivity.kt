package com.example.ind_question_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ind_question_2.ui.theme.IndQuestion2Theme
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndQuestion2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingPersonalized(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun GreetingPersonalized(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var greetingMessage by remember { mutableStateOf("") }


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = name,
            onValueChange = { newName: String -> name = newName },
            label = { "Enter your name" },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                greetingMessage = generateGreeting(name)
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Show Greeting")
        }

        if (greetingMessage.isNotEmpty()) {
            Text(
                text = greetingMessage,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

fun generateGreeting(name: String): String {
    if (name.isBlank()) {
        return "Hello! Please enter your name."
    }

    val calendar = Calendar.getInstance()
    val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)

    val timeBasedGreeting = when (hourOfDay) {
        in 5..11 -> "Good Morning"
        in 12..17 -> "Good Afternoon"
        in 18..21 -> "Good Evening"
        else -> "Hello"
    }

    return "$timeBasedGreeting, $name!"
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IndQuestion2Theme {
        GreetingPersonalized()
    }
}