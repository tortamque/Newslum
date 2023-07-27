package com.example.newsapp.models

import com.example.newsapp.R

object MockData {
    val topNewsList = listOf(
        NewsData(
            id = 1,
            imageId = R.drawable.bear,
            author = "John Doe",
            title = "Bear Spotted Roaming in National Park",
            description = "A bear was spotted roaming freely in the popular national park, causing temporary closures of some trails for safety measures.",
            publishedAt = "2023-07-15T12:00:00Z"
        ),
        NewsData(
            id = 2,
            imageId = R.drawable.football,
            author = "Jane Smith",
            title = "Exciting Football Match Ends in Draw",
            description = "In a thrilling football match, the two teams battled it out to a draw, with both sides displaying exceptional skills and teamwork.",
            publishedAt = "2023-07-15T13:30:00Z"
        ),
        NewsData(
            id = 3,
            imageId = R.drawable.phone,
            author = "Mark Johnson",
            title = "New Smartphone Release with Cutting-Edge Features",
            description = "A leading tech company has unveiled its latest smartphone model, promising groundbreaking features and improved performance.",
            publishedAt = "2023-07-15T14:15:00Z"
        ),
        NewsData(
            id = 4,
            imageId = R.drawable.shark,
            author = "Sarah Lee",
            title = "Rare Shark Sighting Off the Coast",
            description = "A rare species of shark was spotted near the coast, leading marine biologists to conduct further research on its behavior and habitat.",
            publishedAt = "2023-07-15T15:20:00Z"
        ),
        NewsData(
            id = 5,
            imageId = R.drawable.shoot,
            author = "Michael Brown",
            title = "Tensions Escalate in Region Amidst Conflict",
            description = "The region has witnessed an escalation of tensions as the conflict continues, leading to concerns over regional stability.",
            publishedAt = "2023-07-15T16:45:00Z"
        ),
        NewsData(
            id = 6,
            imageId = R.drawable.shop,
            author = "Anna Garcia",
            title = "Grand Opening of New Shopping Mall",
            description = "The much-awaited shopping mall has opened its doors to the public, offering a wide range of retail and entertainment options.",
            publishedAt = "2023-07-15T17:10:00Z"
        ),
        NewsData(
            id = 7,
            imageId = R.drawable.telescope,
            author = "Robert Wilson",
            title = "New Telescope Installed to Explore the Universe",
            description = "A state-of-the-art telescope has been installed, enabling astronomers to observe distant celestial objects with unprecedented clarity.",
            publishedAt = "2023-07-15T18:00:00Z"
        ),
        NewsData(
            id = 8,
            author = "Breaking News",
            title = "Breaking: Major Incident Unfolds",
            description = "A major incident has unfolded, causing widespread concern and emergency response from authorities. Stay tuned for further updates.",
            publishedAt = "2023-07-15T19:30:00Z"
        )
    )
}