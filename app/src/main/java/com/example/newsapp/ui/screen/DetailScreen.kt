package com.example.newsapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.R
import com.example.newsapp.models.NewsData

@Composable
fun DetailScreen(navController: NavController, newsData: NewsData){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Detail Screen", fontWeight = FontWeight.SemiBold)
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Go to Top News Screen")
        }
        Text("News title: ${newsData.title}")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailScreen(){
    DetailScreen(
        rememberNavController(),
        NewsData(
            id = 1,
            imageId = R.drawable.bear,
            author = "John Doe",
            title = "Bear Spotted Roaming in National Park",
            description = "A bear was spotted roaming freely in the popular national park, causing temporary closures of some trails for safety measures.",
            publishedAt = "2023-07-15T12:00:00Z"
        )
    )
}