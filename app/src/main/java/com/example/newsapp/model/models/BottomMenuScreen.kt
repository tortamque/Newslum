package com.example.newsapp.model.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuScreen(val route: String, val icon: ImageVector, val title: String){
    object TopNews: BottomMenuScreen("TopNews", Icons.Outlined.Home, "Top News")
    object Sources: BottomMenuScreen("Sources", Icons.Outlined.List, "Sources")
}
