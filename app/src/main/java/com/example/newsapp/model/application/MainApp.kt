package com.example.newsapp.model.application

import android.app.Application
import com.example.newsapp.model.repository.Repository
import com.example.newsapp.model.manager.NewsManager
import com.example.newsapp.model.models.network.Api

class MainApp: Application() {
    private val manager by lazy {
        NewsManager(Api.retrofitService)
    }

    val repository by lazy {
        Repository(manager)
    }
}