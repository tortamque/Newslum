package com.example.newsapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.example.newsapp.network.models.NewsManager

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sources(
    newsManager: NewsManager
){
    val items = listOf(
        "TechCrunch" to "techcrunch",
        "TalkSport" to "talksport",
        "Business Insider" to "business-insider",
        "Reuters" to "reuters",
        "Politico" to "politico",
        "TheVerge" to "the-verge"
    )

    Scaffold(
        topBar = { TopAppBar(
            title = { Text(text = "News from ${newsManager.sourceName.value}")},
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
                                       Text(it.first)
                                },
                                onClick = {
                                    newsManager.sourceName.value = it.second
                                    isMenuExpanded = false
                            })
                        }
                    }
                }
            }
        )}
    ) {

    }
}