package com.example.newsapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.newsapp.R
import com.example.newsapp.models.MockData
import com.example.newsapp.models.MockData.getTimeAgo
import com.example.newsapp.models.NewsData

@Composable
fun TopNews(navController: NavController, paddingValues: PaddingValues){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
        ){
            item {
                Text(
                    text = "Top News",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                )
            }

            items(MockData.topNewsList){ newsData ->
                TopNewsItem(
                    newsData = newsData,
                    onClick = {
                        navController.navigate("Detail/${newsData.id}")
                    }
                )
            }
        }
    }
}

@Composable
fun TopNewsItem(newsData: NewsData, onClick: ()->Unit = {}){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(20.dp)
    ) {
        Column {
            Box(modifier = Modifier.height(200.dp)){
                Image(
                    painter = painterResource(id = newsData.imageId),
                    contentDescription = newsData.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Column(modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(top = 15.dp, bottom = 15.dp, start = 30.dp, end = 30.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(newsData.title, color = Color.Black, fontWeight = FontWeight.SemiBold, modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 18.sp)
                Spacer(modifier = Modifier
                    .height(15.dp)
                    .fillMaxWidth())
                Row{
                    Text(newsData.author, color = Color.Black, modifier = Modifier.weight(1.0f), fontSize = 16.sp)
                    Text(MockData.stringToDate(newsData.publishedAt).getTimeAgo(), color = Color.Gray, modifier = Modifier
                        .weight(1.0f)
                        .align(Alignment.Bottom), textAlign = TextAlign.End, fontSize = 14.sp)
                }
            }
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