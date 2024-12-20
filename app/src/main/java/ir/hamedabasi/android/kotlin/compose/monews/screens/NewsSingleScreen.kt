package ir.hamedabasi.android.kotlin.compose.monews.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import ir.hamedabasi.android.kotlin.compose.monews.viewmodel.NewsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsSingleScreen(newsViewModel: NewsViewModel, navController: NavController){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                title = {
                Row {
                    Text("Author : " + (newsViewModel.selectedNews?.author ?: "(Not Provided)"), style = MaterialTheme.typography.labelLarge, color = Color.White)
                }
            },
                colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = Color("#ef3d1d".toColorInt()))
            )
        }

        ) { innerPadding ->
        Column (modifier = Modifier.padding(innerPadding)){
            if (newsViewModel.selectedNews != null)
                NewsItemScreen(newsViewModel.selectedNews!!, navController, newsViewModel, fullContent = true)
            else{
                Text("Not provided !")
            }
    }

    }
}