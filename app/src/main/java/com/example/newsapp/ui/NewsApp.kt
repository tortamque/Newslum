package com.example.newsapp.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newsapp.components.BottomMenu
import com.example.newsapp.models.BottomMenuScreen
import com.example.newsapp.models.MockData
import com.example.newsapp.network.models.NewsManager
import com.example.newsapp.ui.screen.Categories
import com.example.newsapp.ui.screen.DetailScreen
import com.example.newsapp.ui.screen.Sources
import com.example.newsapp.ui.screen.TopNews

@Composable
fun NewsApp(){
    val navController = rememberNavController()
    val scrollState = rememberScrollState()

    MainScreen(navController, scrollState)
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navHostController: NavHostController, scrollState: ScrollState){
    Scaffold(bottomBar = { BottomMenu(navController = navHostController)}) {
        Navigation(navHostController, it)
    }
}

@Composable
fun Navigation(navHostController: NavHostController, paddingValues: PaddingValues, newsManager: NewsManager = NewsManager()){
    val articles = newsManager.newsResponse.value.articles
    Log.d("articles", articles.toString())

    NavHost(navController = navHostController, startDestination = "TopNews"){
        bottomNavigation(navController = navHostController, paddingValues = paddingValues)

        composable("TopNews"){
            TopNews(navController = navHostController, paddingValues = paddingValues)
        }

        composable(
            "Detail/{newsId}",
            arguments = listOf(navArgument("newsId") { type = NavType.IntType })
        ){
            val id = it.arguments?.getInt("newsId")
            val newsData = MockData.getNews(id)
            DetailScreen(navController = navHostController, newsData)
        }
    }
}

fun NavGraphBuilder.bottomNavigation(navController: NavController, paddingValues: PaddingValues){
    composable(BottomMenuScreen.TopNews.route){
        TopNews(navController = navController, paddingValues = paddingValues)
    }
    composable(BottomMenuScreen.Categories.route){
        Categories()
    }
    composable(BottomMenuScreen.Sources.route){
        Sources()
    }
}