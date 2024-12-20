package ir.hamedabasi.android.kotlin.compose.monews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.hamedabasi.android.kotlin.compose.monews.screens.NewsListScreen
import ir.hamedabasi.android.kotlin.compose.monews.ui.theme.MoNewsTheme
import ir.hamedabasi.android.kotlin.compose.monews.viewmodel.NewsViewModel

class MainActivity : ComponentActivity() {
    private val vm: NewsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            MoNewsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Main(modifier = Modifier.padding(innerPadding),vm)
                }
            }
        }
    }
}


@Composable
fun Main(modifier: Modifier, viewModel: NewsViewModel){
    NewsListScreen(modifier, viewModel)
}
