package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.newsapp.model.enums.ArticleCategory
import com.example.newsapp.viewmodel.MainViewModel
import com.example.newsapp.model.navigation.NewsApp
import com.example.newsapp.view.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getArticlesByCategory(ArticleCategory.ALL_NEWS.categoryKey)

        setContent {
            NewsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewsApp(viewModel)
                }
            }
        }
    }
}