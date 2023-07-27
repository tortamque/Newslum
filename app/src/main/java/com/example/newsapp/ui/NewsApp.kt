package com.example.newsapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.ui.screen.DetailScreen
import com.example.newsapp.ui.screen.TopNews

@Composable
fun NewsApp(){
    Navigation()
}

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "TopNews"){
        composable("TopNews"){
            TopNews(navController = navController)
        }

        composable("Detail"){
            DetailScreen(navController = navController)
        }
    }
}