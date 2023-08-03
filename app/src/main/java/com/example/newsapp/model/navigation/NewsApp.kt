package com.example.newsapp.model.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newsapp.view.ui.components.BottomMenu
import com.example.newsapp.model.models.BottomMenuScreen
import com.example.newsapp.model.models.network.TopNewsArticle
import com.example.newsapp.view.ui.screen.DetailScreen
import com.example.newsapp.view.ui.screen.Sources
import com.example.newsapp.view.ui.screen.TopNews
import com.example.newsapp.viewmodel.MainViewModel

@Composable
fun NewsApp(mainViewModel: MainViewModel){
    val navController = rememberNavController()
    val scrollState = rememberScrollState()

    MainScreen(navController, scrollState, mainViewModel)
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navHostController: NavHostController, scrollState: ScrollState, mainViewModel: MainViewModel){
    Scaffold(bottomBar = { BottomMenu(navController = navHostController) }) {
        Navigation(navHostController, it, mainViewModel)
    }
}

@Composable
fun Navigation(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: MainViewModel
){
    val articles = viewModel.categoryNewsResponse.collectAsState().value.articles ?: listOf()

    NavHost(navController = navHostController, startDestination = BottomMenuScreen.TopNews.route){
        val queryState = mutableStateOf(viewModel.query.value)

        bottomNavigation(
            navController = navHostController,
            paddingValues = paddingValues,
            articles = articles,
            query = queryState,
            viewModel = viewModel
        )
        composable(
            "Detail/{index}",
            arguments = listOf(navArgument("index") { type = NavType.IntType })
        ){
            val index = it.arguments?.getInt("index")
            index?.let {
                if(queryState.value != ""){
                    articles.toMutableList().clear()
                    articles.toMutableList().addAll(viewModel.queryNewsResponse.value.articles ?: listOf())
                } else{
                    articles.toMutableList().clear()
                    articles.toMutableList().addAll(viewModel.categoryNewsResponse.value.articles ?: listOf())
                }
                val article = articles[index]

                DetailScreen(navController = navHostController, article, paddingValues)
            }
        }
    }
}

fun NavGraphBuilder.bottomNavigation(
    navController: NavController,
    paddingValues: PaddingValues,
    articles: List<TopNewsArticle>,
    query: MutableState<String>,
    viewModel: MainViewModel
){
    composable(BottomMenuScreen.TopNews.route){
        TopNews(
            navController = navController,
            paddingValues = paddingValues,
            articles = articles,
            query = query,
            viewModel = viewModel
        )
    }

    composable(BottomMenuScreen.Sources.route){
        Sources(
            viewModel = viewModel,
            navBarPadding = paddingValues
        )
    }
}