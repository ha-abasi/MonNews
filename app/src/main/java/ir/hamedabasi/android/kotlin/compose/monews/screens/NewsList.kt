package ir.hamedabasi.android.kotlin.compose.monews.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ir.hamedabasi.android.kotlin.compose.monews.retrofit.models.Article
import ir.hamedabasi.android.kotlin.compose.monews.retrofit.models.NewsList
import ir.hamedabasi.android.kotlin.compose.monews.viewmodel.NewsViewModel

@Composable
fun NewsListScreen(modifier: Modifier, newsViewModel: NewsViewModel){
    val newsCount = newsViewModel.news?.totalResults
    Column (modifier = modifier){
        Row {
            Text("News Found : ", style = MaterialTheme.typography.labelLarge)
            Text(if(newsCount == null) "Fetching .." else "$newsCount", style = MaterialTheme.typography.labelSmall)
        }
        LazyColumn {
            newsViewModel.news?.let {
                items(it.articles){ article ->
                    NewsItemScreen(article)
                }
            }
        }
    }

}