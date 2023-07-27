package com.example.newsapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.R
import com.example.newsapp.models.NewsData

@Composable
fun DetailScreen(
    navController: NavController,
    newsData: NewsData,
    scrollState: ScrollState
){
    val defaultPadding = 20.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 20.dp),
    ) {
        Text(
            text = newsData.title,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(vertical = defaultPadding)
        )

        Row(
            Modifier.padding(bottom = defaultPadding/2)
        ) {
            Text(
                newsData.author,
                color = Color.Black,
                modifier = Modifier.weight(1.0f),
                fontSize = 16.sp
            )
            Text(
                newsData.publishedAt,
                color = Color.Gray,
                modifier = Modifier
                    .weight(1.0f)
                    .align(Alignment.Bottom),
                textAlign = TextAlign.End,
                fontSize = 14.sp
            )
        }

        Image(
            painter = painterResource(id = newsData.imageId),
            contentDescription = newsData.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(bottom = defaultPadding)
                .clip(RoundedCornerShape(10.dp))
        )

        Text(
            newsData.description,
            Modifier
                .padding(bottom = defaultPadding)
        )

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .padding(bottom = defaultPadding)
                .align(CenterHorizontally)
        ) {
            Text("Go Back")
        }
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
        ),
        rememberScrollState()
    )
}