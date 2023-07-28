package com.example.newsapp.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.newsapp.models.BottomMenuScreen

@Composable
fun BottomMenu(navController: NavController){
    val menuItems = listOf(BottomMenuScreen.TopNews, BottomMenuScreen.Categories, BottomMenuScreen.Sources)

    NavigationBar(
        contentColor = Color.White
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        menuItems.forEach {
            NavigationBarItem(
                label = {Text(it.title)},
                alwaysShowLabel = true,
                selected = currentRoute == it.route,
                onClick = { /*TODO*/ },
                icon = { Icon(imageVector = it.icon, contentDescription = it.title) }
            )
        }
    }
}