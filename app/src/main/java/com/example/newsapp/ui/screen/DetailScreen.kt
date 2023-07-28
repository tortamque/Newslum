package com.example.newsapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import com.example.newsapp.models.MockData
import com.example.newsapp.models.MockData.getTimeAgo
import com.example.newsapp.models.NewsData


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavController,
    newsData: NewsData,
    externalPaddingValues: PaddingValues
){
    val defaultPadding = 20.dp
    val scrollState = rememberScrollState()
    
    Scaffold(
        topBar = { DetailScreenAppBar(onBackPressed = {navController.popBackStack()}, title = newsData.title)}
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(start = 20.dp, end = 20.dp, bottom = externalPaddingValues.calculateBottomPadding()),
        ) {
            Row(
                Modifier.padding(bottom = defaultPadding/2, top = paddingValues.calculateTopPadding() + defaultPadding/2)
            ) {
                Text(
                    newsData.author,
                    color = Color.Black,
                    modifier = Modifier.weight(1.0f),
                    fontSize = 16.sp
                )
                Text(
                    MockData.stringToDate(newsData.publishedAt).getTimeAgo(),
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
                    .padding(bottom = defaultPadding),
                color = Color.Black
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenAppBar(onBackPressed: ()->Unit = {}, title: String){
    val scrollState = rememberScrollState()

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 21.sp,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .horizontalScroll(scrollState)
            )
        },
        navigationIcon = {
            IconButton(onClick = {onBackPressed()}) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
    )
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
        PaddingValues()
    )
}