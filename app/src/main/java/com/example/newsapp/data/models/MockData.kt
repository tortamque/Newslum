package com.example.newsapp.data.models

import android.os.Build
import com.example.newsapp.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

object MockData {
    val topNewsList = listOf(
        NewsData(
            id = 1,
            imageId = R.drawable.bear,
            author = "John Doe",
            title = "Bear Spotted Roaming in National Park",
            description = "In a surprising turn of events, a bear has been spotted roaming freely within the boundaries of the beloved Silverwood National Park. The sighting has led park authorities to take immediate action, implementing temporary trail closures for the safety of park visitors. Eyewitnesses reported the bear exploring its natural habitat with an air of curiosity and grace. However, as a precautionary measure, park rangers have decided to close some of the most frequented trails in the vicinity until the situation is deemed safe. Silverwood National Park, known for its breathtaking scenery and diverse wildlife, has always been a favorite destination for nature enthusiasts and adventurers alike. The sudden appearance of the bear has added a sense of intrigue and excitement, but also raised concerns among visitors. Park officials urge all visitors to exercise caution and adhere to the guidance provided by rangers during this time. While encounters with bears are rare, they emphasize the importance of respecting the wildlife and maintaining a safe distance from any wild animals that may be encountered. A team of experienced wildlife experts is currently on-site to monitor the bear's movements and behavior. The goal is to ensure the safety of both park visitors and the bear itself. Park authorities are closely monitoring the situation and will gradually reopen trails as soon as it is deemed safe to do so. For the time being, park visitors are encouraged to enjoy the other areas of the park that remain open, where they can still experience the park's natural beauty and abundance of flora and fauna. Silverwood National Park remains committed to the preservation of its natural treasures and the safety of its visitors. Updates on the situation will be regularly provided to the public, and park officials will continue to work diligently to ensure a safe and enjoyable experience for everyone. Please stay tuned for further updates as this exciting and unique situation unfolds. The park's dedicated team is working around the clock to protect both the bear and the cherished visitors of Silverwood National Park. Remember, in the presence of wildlife, caution is key. Let's all be responsible stewards of nature as we continue to appreciate the wonders of this extraordinary national park.",
            publishedAt = "2023-07-27T12:00:00Z"
        ),
        NewsData(
            id = 2,
            imageId = R.drawable.football,
            author = "Jane Smith",
            title = "Exciting Football Match Ends in Draw",
            description = "In an exhilarating football showdown, two formidable teams clashed on the field, captivating fans with their electrifying performance. The intense match culminated in a pulsating draw, leaving spectators in awe of the extraordinary display of skill and teamwork. From the opening whistle, it was evident that this encounter would be one for the ages. Both teams exhibited unwavering determination and resilience, refusing to back down in the face of fierce competition. The players' passion and commitment to their respective clubs were palpable, adding an extra layer of excitement to the already charged atmosphere. Throughout the ninety minutes of play, the momentum swung like a pendulum, with each side launching relentless attacks and valiantly defending their goalposts. Tantalizing dribbles, razor-sharp passes, and thunderous shots at the net sent waves of adrenaline through the crowd.",
            publishedAt = "2023-07-26T13:30:00Z"
        ),
        NewsData(
            id = 3,
            imageId = R.drawable.phone,
            author = "Mark Johnson",
            title = "New Smartphone Release with Cutting-Edge Features",
            description = "In a highly anticipated event, the tech industry witnessed a momentous revelation as a renowned tech giant pulled back the curtain on its latest marvel. The new flagship smartphone, a true masterpiece of engineering, has set the tech world abuzz with excitement and awe. With a strong commitment to pushing the boundaries of innovation, the leading tech company has left no stone unturned in crafting a smartphone that sets a new standard for excellence. Packed with groundbreaking features and boasting improved performance, this cutting-edge device is poised to reshape the landscape of mobile technology. Tech enthusiasts and industry experts alike are raving about the host of new features that have been seamlessly integrated into this sleek and stylish device. From a mesmerizing display that captivates the eyes with vibrant colors and crystal-clear resolution to an advanced camera system that captures life's precious moments in unprecedented detail, this smartphone is a true visionary's dream.",
            publishedAt = "2023-07-25T14:15:00Z"
        ),
        NewsData(
            id = 4,
            imageId = R.drawable.shark,
            author = "Sarah Lee",
            title = "Rare Shark Sighting Off the Coast",
            description = "In a thrilling discovery, marine biologists have recently spotted a rare and elusive species of shark near the coastal waters. This unprecedented sighting has sent shockwaves through the scientific community, as the species was thought to be extremely rare and seldom seen. The marine biologists responsible for the breakthrough observation were conducting routine research on marine life when they encountered the majestic creature. With its distinctive markings and unusual behavior, it became evident that this was no ordinary shark. As news of the discovery spread like wildfire, experts from around the world have been drawn to the area to witness the phenomenon firsthand. The newfound shark's unique appearance and behavior have left scientists intrigued and eager to uncover its secrets. Experts are now tirelessly working to conduct further research on this mysterious species, hoping to understand its behavior, habitat, and role in the marine ecosystem. Observations and data collected from this rare encounter will undoubtedly pave the way for groundbreaking insights into the underwater world.",
            publishedAt = "2023-07-24T15:20:00Z"
        ),
        NewsData(
            id = 5,
            imageId = R.drawable.shoot,
            author = "Michael Brown",
            title = "Tensions Escalate in Region Amidst Conflict",
            description = "The region is facing a surge in tensions as the ongoing conflict continues unabated, raising serious concerns over regional stability. Recent developments have escalated the situation, leaving many anxious about the potential implications on the fragile peace in the area. Reports from reliable sources indicate that the conflict, which has been simmering for some time, has now reached a critical point. Both sides have engaged in hostilities, leading to a surge in violence and instability. Local authorities and international organizations are closely monitoring the situation, recognizing the gravity of the escalating tensions. The root causes of the conflict remain complex and multifaceted, making it challenging to find a swift resolution. Issues relating to territorial disputes, historical grievances, and political disagreements have contributed to the growing tensions. As the situation unfolds, diplomatic efforts are underway to mediate between the conflicting parties and seek a peaceful resolution to prevent further escalation.",
            publishedAt = "2023-07-23T16:45:00Z"
        ),
        NewsData(
            id = 6,
            imageId = R.drawable.shop,
            author = "Anna Garcia",
            title = "Grand Opening of New Shopping Mall",
            description = "The city's much-awaited shopping paradise has finally opened its doors to the eager public, igniting excitement and anticipation among shopaholics and entertainment enthusiasts alike. The dazzling new shopping mall, adorned with modern architectural marvels, stands as a testament to urban sophistication and retail extravaganza. With its grand opening, the mall unveils a captivating world of possibilities, where visitors are spoilt for choice with an impressive array of retail stores, boutiques, and flagship outlets from renowned brands. From haute couture fashion boutiques to state-of-the-art electronics emporiums, the shopping options cater to every discerning taste and lifestyle. Entertainment takes center stage as visitors indulge in a kaleidoscope of amusement choices. An expansive entertainment zone houses thrilling amusement rides, engaging arcade games, and a multiscreen cinema, promising an unforgettable experience for families and friends seeking unforgettable moments of laughter and joy.",
            publishedAt = "2023-07-23T17:10:00Z"
        ),
        NewsData(
            id = 7,
            imageId = R.drawable.telescope,
            author = "Robert Wilson",
            title = "New Telescope Installed to Explore the Universe",
            description = "In a momentous leap forward for astronomy, a cutting-edge telescope has been successfully installed, granting astronomers an unprecedented view into the depths of the universe. With the capacity to peer into distant celestial objects like never before, this state-of-the-art telescope promises to revolutionize our understanding of the cosmos. The ambitious project, a collaboration between leading space agencies and astrophysics institutes, represents years of meticulous planning and engineering. Nestled in a remote location, far from the interference of city lights and atmospheric disturbances, the telescope stands tall, reaching for the heavens it seeks to unveil. What sets this remarkable instrument apart is its unrivaled clarity. Advanced imaging technologies and precision optics allow astronomers to capture celestial phenomena with breathtaking detail. From the dazzling dance of distant galaxies to the delicate wisps of nebulae, every observation paints a mesmerizing picture of the cosmos.",
            publishedAt = "2023-07-22T18:00:00Z"
        ),
        NewsData(
            id = 8,
            author = "Robert Brown",
            title = "Breaking: Major Incident Unfolds",
            description = "In a sudden and unexpected turn of events, a major incident has unfolded, sending shockwaves through the community and sparking widespread concern. Authorities have swiftly sprung into action, initiating an emergency response to address the situation. As the details of the incident continue to emerge, residents are urged to stay vigilant and remain tuned to updates from local authorities and news outlets. The exact nature and extent of the incident are yet to be fully determined, and officials are working diligently to gather all relevant information. Reports indicate that emergency services have been deployed to the scene, and first responders are working tirelessly to ensure the safety and well-being of those affected. The situation remains fluid, and authorities are urging everyone to avoid the area until further notice.",
            publishedAt = "2023-07-22T19:30:00Z"
        )
    )

    fun getNews(id: Int?): NewsData {
        return topNewsList.first{
            it.id == id
        }
    }

    fun Date.getTimeAgo(): String {
        val calendar = Calendar.getInstance()
        calendar.time = this

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val currentCalendar = Calendar.getInstance()

        val currentYear = currentCalendar.get(Calendar.YEAR)
        val currentMonth = currentCalendar.get(Calendar.MONTH)
        val currentDay = currentCalendar.get(Calendar.DAY_OF_MONTH)
        val currentHour = currentCalendar.get(Calendar.HOUR_OF_DAY)
        val currentMinute = currentCalendar.get(Calendar.MINUTE)

        return if (year < currentYear) {
            val interval = currentYear - year
            if (interval == 1) "$interval year ago" else "$interval years ago"
        } else if (month < currentMonth) {
            val interval = currentMonth - month
            if (interval == 1) "$interval month ago" else "$interval months ago"
        } else if (day < currentDay) {
            val interval = currentDay - day
            if (interval == 1) "$interval day ago" else "$interval days ago"
        } else if (hour < currentHour) {
            val interval = currentHour - hour
            if (interval == 1) "$interval hour ago" else "$interval hours ago"
        } else if (minute < currentMinute) {
            val interval = currentMinute - minute
            if (interval == 1) "$interval minute ago" else "$interval minutes ago"
        } else {
            "a moment ago"
        }
    }

    fun stringToDate(publishedAt: String): Date {
        val date =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH).parse(publishedAt)
            } else {
                java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH).parse(publishedAt)
            }
        return date
    }
}