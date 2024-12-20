package ir.hamedabasi.android.kotlin.compose.monews.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.hamedabasi.android.kotlin.compose.monews.ApiKey
import ir.hamedabasi.android.kotlin.compose.monews.repository.NewsRepository
import ir.hamedabasi.android.kotlin.compose.monews.retrofit.models.NewsList
import kotlinx.coroutines.launch
import java.io.File

class NewsViewModel: ViewModel() {

    private val repository = NewsRepository()


    // mutableStateOf make sure any getter of news variable get latest updates
    // of the variable
    //
    // Note: any composable who depends on a variable type mutableStateOf, if the variable
    // get updated, the composable will be regenerated
    //
    var news by mutableStateOf<NewsList?>(null)
        private set // Only current class can set the value


    init {
        refresh()
    }

    fun refresh(){
        news = null // clear
        viewModelScope.launch {
            val newsList = repository.getNews(ApiKey.apiKey) // fetch network data
            news = newsList // update the state, cause the composable to be regenerated
        }
    }
}