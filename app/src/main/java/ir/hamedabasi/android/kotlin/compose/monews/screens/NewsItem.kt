package ir.hamedabasi.android.kotlin.compose.monews.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ir.hamedabasi.android.kotlin.compose.monews.retrofit.models.Article

@Composable
fun NewsItemScreen(article: Article){
    var content = article.content
    if (content == null){
        content = "(Content Not Provided)"
    }else{
        if (content.length > 110) content = content.substring(0, 100) + " ..."
    }
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(12.dp).fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)){
            AsyncImage(model = article.urlToImage, contentDescription = "Image")
            Text(article.title ?: "(Title Not Provided)", style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(5.dp))
            Text( content, style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(5.dp))
            Text(article.publishedAt?.toString() ?: "(Content Not Provided)", style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(5.dp))
        }
    }
}