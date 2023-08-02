package com.example.newsapp.network.models

enum class SourcesEnum(val sourceName: String, val sourceKey: String){
    NBCNews("NBC News", "nbcnews.com"),
    TechCrunch("TechCrunch", "techcrunch.com"),
    TalkSport("TalkSport" , "talksport.com"),
    BusinessInsider("Business Insider" , "businessinsider.com"),
    Reuters("Reuters" , "reuters.com"),
    Politico("Politico" , "politico.com"),
    TheVerge("The Verge" , "theverge.com")
}