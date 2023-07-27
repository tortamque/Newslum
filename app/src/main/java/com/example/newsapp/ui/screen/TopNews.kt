package com.example.newsapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newsapp.R
import com.example.newsapp.models.MockData
import com.example.newsapp.models.NewsData

@Composable
fun TopNews(navController: NavController){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Top News", fontWeight = FontWeight.SemiBold)
        LazyColumn(){
            items(MockData.topNewsList){
                TopNewsItem(newsData = it)
            }
        }
    }
}

@Composable
fun TopNewsItem(newsData: NewsData){
    Box(
        modifier = Modifier
        .height(200.dp)
        .fillMaxWidth()
        .padding(8.dp),
    ) {
        Image(
            painter = painterResource(id = newsData.imageId),
            contentDescription = newsData.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = Modifier
            .wrapContentHeight()
            .padding(top = 16.dp, start = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(newsData.publishedAt, color = Color.White, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(80.dp))
            Text(newsData.title, color = Color.White, fontWeight = FontWeight.SemiBold)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTopNews(){
    //TopNews(rememberNavController())
    TopNewsItem(
        NewsData(
            id = 2,
            imageId = R.drawable.football,
            author = "Jane Smith",
            title = "Exciting Football Match Ends in Draw",
            description = "In a thrilling football match, the two teams battled it out to a draw, with both sides displaying exceptional skills and teamwork.",
            publishedAt = "2023-07-15T13:30:00Z"
        )
    )
}