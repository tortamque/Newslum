package com.example.newsapp.view.ui.screen

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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.R
import com.example.newsapp.model.models.DateConverter
import com.example.newsapp.model.models.DateConverter.Companion.getTimeAgo
import com.example.newsapp.model.models.network.TopNewsArticle
import com.skydoves.landscapist.coil.CoilImage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavController,
    article: TopNewsArticle,
    externalPaddingValues: PaddingValues
){
    val defaultPadding = 20.dp
    val scrollState = rememberScrollState()
    val urlHandler = LocalUriHandler.current
    
    Scaffold(
        topBar = {
            DetailScreenAppBar(
                onBackPressed = {
                    navController.popBackStack()
                },
                title = article.title?:"Not available"
            )
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    bottom = externalPaddingValues.calculateBottomPadding()
                ),
        ) {
            Row(
                Modifier.padding(bottom = defaultPadding/2, top = paddingValues.calculateTopPadding() + defaultPadding/2)
            ) {
                Text(
                    article.author?:"Not available",
                    color = Color.Black,
                    modifier = Modifier.weight(1.0f),
                    fontSize = 16.sp
                )
                Text(
                    DateConverter.stringToDate(article.publishedAt!!).getTimeAgo(),
                    color = Color.Gray,
                    modifier = Modifier
                        .weight(1.0f)
                        .align(Alignment.Bottom),
                    textAlign = TextAlign.End,
                    fontSize = 14.sp
                )
            }
            CoilImage(
                imageModel = article.urlToImage,
                contentScale = ContentScale.Crop,
                error = ImageBitmap.imageResource(id = R.drawable.placeholder),
                placeHolder = ImageBitmap.imageResource(id = R.drawable.placeholder),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = defaultPadding)
                    .clip(RoundedCornerShape(10.dp))
            )

            Text(
                article.description?:"Not available",
                Modifier
                    .padding(bottom = defaultPadding),
                color = Color.Black
            )

            Button(
                onClick = {
                    article.url?.let {
                        urlHandler.openUri(it)
                    }
                },
                modifier = Modifier
                    .padding(bottom = defaultPadding)
                    .align(CenterHorizontally)
            ) {
                Text("Read full article")
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
        TopNewsArticle(
            author = "John Doe",
            title = "Bear Spotted Roaming in National Park",
            description = "A bear was spotted roaming freely in the popular national park, causing temporary closures of some trails for safety measures.",
            publishedAt = "2023-07-15T12:00:00Z"
        ),
        PaddingValues()
    )
}