package com.example.newsapp.ui.screen

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.newsapp.R
import com.example.newsapp.components.CategoriesTab
import com.example.newsapp.components.SearchBar
import com.example.newsapp.data.models.MockData
import com.example.newsapp.data.models.MockData.getTimeAgo
import com.example.newsapp.data.models.repository.TopNewsArticle
import com.example.newsapp.network.models.NewsManager
import com.example.newsapp.ui.MainViewModel
import com.skydoves.landscapist.coil.CoilImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNews(
    navController: NavController,
    paddingValues: PaddingValues,
    articles: List<TopNewsArticle>,
    newsManager: NewsManager,
    query: MutableState<String>,
    viewModel: MainViewModel
){
    Scaffold(
        topBar = { CenterAlignedTopAppBar(
            title = { Text("Top News") }
        )}
    ){ scaffoldPaddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(scaffoldPaddingValues)
                .fillMaxWidth(),
        ) {
            SearchBar(query = query, newsManager = newsManager)

            val results = mutableListOf<TopNewsArticle>()
            searchArticles(
                query = query,
                results = results,
                newsManager = newsManager,
                articles = articles
            )

            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
            ){
                item {
                    CategoriesTab(
                        viewModel = viewModel,
                        onFetch = {category ->
                            viewModel.onSelectedCategoryChanged(category)
                            viewModel.getArticlesByCategory(category.categoryKey)
                        })
                }

                items(results.size){ index ->
                    TopNewsItem(
                        article = results[index],
                        onClick = {
                            navController.navigate("Detail/$index")
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun TopNewsItem(article: TopNewsArticle, onClick: ()->Unit = {}){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(20.dp)
    ) {
        Column {
            Box(modifier = Modifier.height(200.dp)){
                CoilImage(
                    imageModel = article.urlToImage,
                    contentScale = ContentScale.Crop,
                    error = ImageBitmap.imageResource(id = R.drawable.placeholder),
                    placeHolder = ImageBitmap.imageResource(id = R.drawable.placeholder),
                    modifier = Modifier.fillMaxSize()
                )
            }
            Column(modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(top = 15.dp, bottom = 15.dp, start = 30.dp, end = 30.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                article.title?.let {
                    Text(article.title, color = Color.Black, fontWeight = FontWeight.SemiBold, modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 18.sp)
                }
                Spacer(modifier = Modifier
                    .height(15.dp)
                    .fillMaxWidth())
                Row{
                    Text(article.author?:"Unknown", color = Color.Black, modifier = Modifier.weight(1.0f), fontSize = 16.sp)
                    article.publishedAt?.let {
                        Text(
                            MockData.stringToDate(article.publishedAt).getTimeAgo(), color = Color.Gray, modifier = Modifier
                            .weight(1.0f)
                            .align(Alignment.Bottom), textAlign = TextAlign.End, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTopNews(){
    TopNewsItem(
        TopNewsArticle(
            author = "Jane Smith",
            title = "Exciting Football Match Ends in Draw",
            description = "In a thrilling football match, the two teams battled it out to a draw, with both sides displaying exceptional skills and teamwork.",
            publishedAt = "2023-07-15T13:30:00Z"
        )
    )
}

fun searchArticles(
    query: MutableState<String>,
    results:  MutableList<TopNewsArticle>,
    newsManager: NewsManager,
    articles: List<TopNewsArticle>
){
    val searchText = query.value
    if(searchText != ""){
        results.addAll(newsManager.searchNewsResponse.value.articles ?: articles)
    } else{
        results.addAll(articles)
    }
}