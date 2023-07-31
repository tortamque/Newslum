package com.example.newsapp.network.models

enum class SourcesEnum(val sourceName: String, val sourceKey: String){
    ABCNews("ABC News", "abc-news"),
    TechCrunch("TechCrunch", "techcrunch"),
    TalkSport("TalkSport" , "talksport"),
    BusinessInsider("Business Insider" , "business-insider"),
    Reuters("Reuters" , "reuters"),
    Politico("Politico" , "politico"),
    TheVerge("TheVerge" , "the-verge")
}