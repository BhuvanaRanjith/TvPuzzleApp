package com.bhuvana.tvpuzzleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.tv.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.bhuvana.tvpuzzleapp.data.PuzzleRepository
import com.bhuvana.tvpuzzleapp.model.PuzzleViewModel
import com.bhuvana.tvpuzzleapp.ui.theme.TvPuzzleAppTheme
import com.bhuvana.tvpuzzleapp.ui.theme.ui.PuzzleQuestionScreen

class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TvPuzzleAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = RectangleShape
                ) {
                    Greeting("Android")

                }
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
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
    TvPuzzleAppTheme {
        Greeting("Android")
    }
}