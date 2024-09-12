package com.example.ind_question_1

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
import com.example.ind_question_1.ui.theme.IndQuestion1Theme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndQuestion1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuoteDisplay(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun QuoteDisplay(modifier: Modifier = Modifier){
    val quotes = listOf(
        "Believe you can and you're halfway there.",
        "Your limitation—it’s only your imagination.",
        "Push yourself, because no one else is going to do it for you.",
        "Great things never come from comfort zones.",
        "Dream it. Wish it. Do it."
    )

    var currentQuote by remember { mutableStateOf(quotes.random()) }

    // Layout for the quote display and button
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Text(
            text = currentQuote,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(16.dp)
        )

        Button(onClick = { currentQuote = quotes.random() }) {
            Text(text = "Change Quote")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IndQuestion1Theme {
        QuoteDisplay()
    }
}