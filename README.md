<a href="https://developer.android.com/jetpack/compose"><img src="https://i.imgur.com/eioTbyF.png" align="right" width="4.75%"></a>
<a href="https://kotlinlang.org/"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Kotlin_Icon.svg/2048px-Kotlin_Icon.svg.png" align="right" width="5%"></a>
# Newslum

## Description
Newslum is a powerful news aggregator app developed using Jetpack Compose, which brings you the latest headlines from various trusted sources. Stay updated with news from all around the world, read full articles in-app, or open them in your browser for a seamless reading experience. The app is designed following the MVVM architecture pattern, ensuring efficient data handling and user interaction.

## Table of Contents
- [Features](#features)
- [Architecture](#architecture)
- [Supported platforms](#supported-platforms)
- [Installation](#installation)
- [Usage](#usage)
- [Screenshots and Demo](#screenshots-and-demo)
- [Used Packages](#used-packages)
- [License](#license)

<a name="features"/></a>
## Features
- Get the latest news from various trusted sources.
- Read short descriptions of news articles for quick browsing.
- Access full articles on the web using an integrated browser for a seamless reading experience.
- Search for news articles by title to find specific topics of interest.
- Filter news by category for focused and personalized news updates.
- Read news articles from specific sources to stay informed from your preferred publishers.

<a name="architecture"/></a>
## Architecture
![architecture](https://github.com/tortamque/Newslum/assets/90132962/dc102265-a0c2-4ba0-84fb-18bddb2cd42b)

<a name="supported-platforms"/></a>
## Supported platforms
Newslum is a mobile application that supports <b>Android</b> platform.

<a name="installation"/></a>
## Installation
To run the Newslum locally, follow these steps:

1. Clone this repository to your local machine.
2. Open Android Studio and select "Open an existing project."
3. Navigate to the project directory and select the project's root folder.
4. Connect a device or start an emulator.
5. Build and run the app by clicking on the "Run" button in Android Studio or by running the command `./gradlew` installDebug in the project's root directory.

<a name="usage"/></a>
## Usage
1. Open Newslum on your device or emulator.
2. Tap on the news card you want to read.
3. To access the full article, click on the "Read full article" button.
4. If you want to find news by interest, enter the appropriate query in the search bar.
5. For reading articles in a specific category, choose the desired category from the options below the search bar.
6. To read news from a specific source, navigate to the "Sources" tab.
7. Select a source by tapping the three dots button on the app bar.

<a name="screenshots-and-demo"/></a>
## Screenshots and Demo
### Screenshots
<img src="https://github.com/tortamque/Newslum/assets/90132962/dae4682e-6143-4e53-8025-f64cfebb8e50" alt="Screenshot_1" width="200">
<img src="https://github.com/tortamque/Newslum/assets/90132962/6235589a-271a-4dc3-b908-2c8e73113ff6" alt="Screenshot_2" width="200">
<img src="https://github.com/tortamque/Newslum/assets/90132962/31a2f24d-9eeb-42c1-b399-78e84c7aa744" alt="Screenshot_3" width="200">
<img src="https://github.com/tortamque/Newslum/assets/90132962/302351d4-a2ff-4548-bae2-63401c309ecc" alt="Screenshot_4" width="200">
<img src="https://github.com/tortamque/Newslum/assets/90132962/b6e35b2a-44c2-4335-b4c0-cfff3d6d04e9" alt="Screenshot_5" width="200">
<img src="https://github.com/tortamque/Newslum/assets/90132962/9d5cfabb-d8a1-4d6f-8a0b-4b7f518185b9" alt="Screenshot_6" width="200">
<img src="https://github.com/tortamque/Newslum/assets/90132962/2a8189fd-c420-477c-8395-5c40e88ea388" alt="Screenshot_7" width="200">
<img src="https://github.com/tortamque/Newslum/assets/90132962/a196fed5-6c92-476a-9ccc-90b83b8a4057" alt="Screenshot_8" width="200">

### Demo
https://github.com/tortamque/Newslum/assets/90132962/5490b05d-7b7d-4170-b8ac-71ed06fdd7c8

<a name="used-packages"/></a>
## Used Packages
The Newslum app utilizes the following packages:

| Name                            | Version   | Link on Maven Repository                                                                      |
|---------------------------------|-----------|-----------------------------------------------------------------------------------------------|
| Logging Interceptor             | 4.7.2     | [Link](https://mvnrepository.com/artifact/com.squareup.okhttp3/logging-interceptor)           |
| Landscapist Coil                | 1.4.1     | [Link](https://mvnrepository.com/artifact/com.github.skydoves/landscapist-coil)               |
| Moshi Kotlin                    | 1.9.3     | [Link](https://mvnrepository.com/artifact/com.squareup.moshi/moshi-kotlin)                    |
| Converter: Moshi                | 2.9.0     | [Link](https://mvnrepository.com/artifact/com.squareup.retrofit2/converter-moshi)             |
| Retrofit                        | 2.9.0     | [Link](https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit)                    |
| Compose Material Icons Extended | 1.4.3     | [Link](https://mvnrepository.com/artifact/androidx.compose.material/material-icons-extended)  |
| Compose Navigation              | 2.7.0-rc01| [Link](https://mvnrepository.com/artifact/androidx.navigation/navigation-compose)             |

<a name="licenses"/></a>
## License
Apache License Version 2.0
