package ir.hamedabasi.android.kotlin.compose.monews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.hamedabasi.android.kotlin.compose.monews.screens.NewsListScreen
import ir.hamedabasi.android.kotlin.compose.monews.screens.NewsSingleScreen
import ir.hamedabasi.android.kotlin.compose.monews.ui.theme.MoNewsTheme
import ir.hamedabasi.android.kotlin.compose.monews.viewmodel.NewsViewModel

class MainActivity : ComponentActivity() {
    private val vm: NewsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            MoNewsTheme {
                Main(vm)
            }
        }
    }
}


@Composable
fun Main(viewModel: NewsViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "news_list"){
        composable("news_list"){ NewsListScreen(viewModel, navController) }
        composable("news_item"){ NewsSingleScreen(viewModel, navController) }
    }
}
