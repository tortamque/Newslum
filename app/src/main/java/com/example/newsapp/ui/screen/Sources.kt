package com.example.newsapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.R
import com.example.newsapp.data.models.repository.TopNewsArticle
import com.example.newsapp.network.models.SourcesEnum
import com.example.newsapp.ui.MainViewModel
import com.skydoves.landscapist.coil.CoilImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sources(
    viewModel: MainViewModel,
    navBarPadding: PaddingValues
){
    val items = SourcesEnum.values()

    Scaffold(
        topBar = { CenterAlignedTopAppBar(
            title = { Text(text = "News from ${viewModel.sourceName.collectAsState().value.sourceName}")},
            actions = {
                var isMenuExpanded by remember { mutableStateOf(false)}
                IconButton(onClick = {
                    isMenuExpanded = true
                }) {
                    Icon(Icons.Default.MoreVert, contentDescription = null)
                }

                MaterialTheme(
                    shapes = MaterialTheme.shapes.copy(
                        extraSmall = RoundedCornerShape(16.dp),
                    )
                ){
                    DropdownMenu(expanded = isMenuExpanded, onDismissRequest = {
                        isMenuExpanded = false
                    }) {
                        items.forEach {
                            DropdownMenuItem(
                                text = {
                                       Text(it.sourceName)
                                },
                                onClick = {
                                    viewModel.sourceName.value = it
                                    viewModel.getArticlesBySource()
                                    isMenuExpanded = false
                            })
                        }
                    }
                }
            }
        )
        }
    ) { appBarPadding ->
        viewModel.getArticlesBySource()
        val articlesBySource = viewModel.sourceNewsResponse.collectAsState().value

        SourceContent(
            articles = articlesBySource.articles ?: listOf(),
            appBarPadding,
            navBarPadding
        )
    }
}

@Composable
fun SourceContent(
    articles: List<TopNewsArticle>,
    appBarPadding: PaddingValues,
    navBarPadding: PaddingValues,
){
    LazyColumn(
        modifier = Modifier
            .padding(top = appBarPadding.calculateTopPadding(), bottom = navBarPadding.calculateBottomPadding())
    ){
        items(articles){ article ->
            SourceItem(article)
        }
    }
}

@Composable
fun SourceItem(article: TopNewsArticle){
    val urlHandler = LocalUriHandler.current
    val descriptionScrollState = rememberScrollState()

    Card(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(200.dp)
    ){
        Column(
            Modifier.padding(15.dp)
        ){
            Row(
                Modifier.weight(5.0f)
            ){
                Column(
                    Modifier
                        .padding(end = 10.dp)
                        .weight(3.0f)){
                    Text(
                        article.title ?: "Not available",
                        maxLines = 3,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        article.description ?: "Not available",
                        color = Color.Gray,
                        fontSize = 15.sp,
                        modifier = Modifier.verticalScroll(descriptionScrollState)
                    )
                }
                CoilImage(
                    imageModel = article.urlToImage,
                    contentScale = ContentScale.Crop,
                    error = ImageBitmap.imageResource(id = R.drawable.placeholder),
                    placeHolder = ImageBitmap.imageResource(id = R.drawable.placeholder),
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .weight(2.0f)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxSize()
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .weight(1.0f)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    "Read the full article",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                )
                IconButton(onClick = {
                    article.url?.let { urlHandler.openUri(it) }
                }) {
                    Icon(imageVector = Icons.Outlined.ArrowForward, contentDescription = null)
                }
            }
        }
    }
}