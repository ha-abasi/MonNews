package ir.hamedabasi.android.kotlin.compose.monews.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt
import ir.hamedabasi.android.kotlin.compose.monews.viewmodel.NewsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsListScreen(newsViewModel: NewsViewModel){
    val newsCount = newsViewModel.news?.totalResults
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                Row {
                    Text("News Found : ", style = MaterialTheme.typography.labelLarge, color = Color.White)
                    Text(if(newsCount == null) "Fetching .." else "$newsCount", style = MaterialTheme.typography.labelLarge, color = Color.Yellow)
                }
            },
                colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = Color("#ef3d1d".toColorInt()))
            )
        }

        ) { innerPadding ->
        Column (modifier = Modifier.padding(innerPadding)){
        LazyColumn {
            newsViewModel.news?.let {
                items(it.articles){ article ->
                    NewsItemScreen(article)
                }
            }
        }
    }

    }
}