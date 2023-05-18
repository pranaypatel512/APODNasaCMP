![](https://github.com/pranaypatel512/APODNasaCMP/blob/main/extra/APODNasaCMP.svg)
<div id="top"></div>

# APODNasaCMP 🪐 - Kotlin Multiplatform app

App related to show [Astronomy Picture of the Day(APOD)](http://apod.nasa.gov/apod/astropix.html)
for last seven days. An app to show media listing using [APOD](https://api.nasa.gov/) api having
image/gif/video.

<p align="left">
      <a href = "https://github.com/JetBrains/compose-multiplatform/releases">
        <img src = "https://img.shields.io/badge/Compose%20Multiplatform-1.4.0-blue.svg?color=blue&style=for-the-badge" />
      </a>
      <a href="https://kotlinlang.org/docs/releases.html">
        <img src="https://img.shields.io/badge/Kotlin-1.8.20-blue.svg?color=blue&style=for-the-badge"/>
      </a>
      <a href = "https://github.com/pranaypatel512/APODNasaCMP/stargazers">
        <img src="https://img.shields.io/github/stars/pranaypatel512/APODNasaCMP?color=blue&style=for-the-badge" />
      </a>
      <a href = "https://github.com/pranaypatel512/APODNasaCMP/network/members">
          <img src="https://img.shields.io/github/forks/pranaypatel512/APODNasaCMP?color=blue&style=for-the-badge" />
      </a>
      <a href = "https://github.com/pranaypatel512/APODNasaCMP/watchers">
          <img src="https://img.shields.io/github/watchers/pranaypatel512/APODNasaCMP?color=blue&style=for-the-badge" />
      </a>
      <a href = "https://github.com/pranaypatel512/APODNasaCMP/pulls">
         <img src="https://img.shields.io/github/issues-pr/pranaypatel512/APODNasaCMP?color=blue&style=for-the-badge" alt="Pull Requests Badge"/>
      </a>
      <a href = "https://github.com/pranaypatel512/APODNasaCMP/issues">
          <img src="https://img.shields.io/github/issues/pranaypatel512/APODNasaCMP?color=blue&style=for-the-badge" />
      </a>
  </p>

## Run a project

- Go to [https://api.nasa.gov/#signUp](https://api.nasa.gov/) and create/request new api key.
- Put generated api key in `local.properties` with property name *`apiKey`* . Now sync project and
  run the app.
  - e.g `apiKey="key"`
- Now navigate to [“Browse APIs”](https://api.nasa.gov/#browseAPI) → Expand APOD
  - API Base Url is [https://api.nasa.gov/planetary/apod](https://api.nasa.gov/planetary/apod)
  - Further query params to fetch in a date range are provided in the document
  - Example api call having all type of media including
    image/gif/video : https://api.nasa.gov/planetary/apod?start_date=2022-05-01&end_date=2022-05-31&thumbs=true&api_key=[your_api_key]

## Project structure 

The project currently has 3 main modules:

  ### 1. [androidApp](https://github.com/pranaypatel512/APODNasaCMP/tree/main/androidApp)

This module contains the android application's UI built using [Jetpack compose](https://developer.android.com/jetpack/compose).

  ### 2. [desktopApp](https://github.com/pranaypatel512/APODNasaCMP/tree/main/desktopApp)

This module contains the desktop application's UI built using [Compose Multiplatform](https://www.jetbrains.com/lp/compose-mpp/).

  ### 3. [iOSApp](https://github.com/pranaypatel512/APODNasaCMP/tree/main/iosApp)

This module contains the iOS application's UI built using [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform-ios-android-template/#readme). 🤩

  ### 4. [shared](https://github.com/pranaypatel512/APODNasaCMP/tree/main/shared)

This module contains shared code that holds the common [Compose Multiplatform](https://www.jetbrains.com/lp/compose-mpp/) ui along with domain and data layers.

## Built With 🛠

| Tools                 |                                     Link                                      |
|:----------------------|:-----------------------------------------------------------------------------:|
| 🤖  Language          |                       [Kotlin](https://kotlinlang.org)                        |
| 🩶  Framework         |  [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform)  |
| 💉  DI                |          [Koin](https://insert-koin.io/docs/reference/koin-mp/kmp/)           |
| 🧶  Multi-threading   |     [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines)      |
| 🌐  Networking        |                    [Ktor](https://github.com/ktorio/ktor)                     |
| 🕜  Lifecycle         |                [Essenty](https://github.com/arkivanov/Essenty)                |
| 📁  State Management  |              [Decompose](https://github.com/arkivanov/decompose)              |
| 🧭  Navigation        |              [xxfast/KRouter](https://github.com/xxfast/KRouter)              |
| 📐  Window Insets     |              [InsetsX](https://github.com/mori-atsushi/insetsx)               |

## ⚒️ Architecture

This app follows the principles of [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html).

## ✅ Lint 

* This project uses [ktlint](https://pinterest.github.io/ktlint/) and [detekt](https://github.com/detekt/detekt) for validate kotlin code.
* Project will setup [githook](https://git-scm.com/docs/githooks) to validate code before commit.


## 📷 Screenshots / Video

Coming soon...

## 🤝 Contribute

- If you want to contribute to this library, you're always welcome!
See [Contributing Guidelines](CONTRIBUTING.md).

### :envelope: Get in touch!

[![Medium](https://img.shields.io/badge/-medium-gray?style=for-the-badge&logo=medium)](https://medium.com/@pranaypatel)
[![Twitter](https://img.shields.io/badge/-twitter-gray?style=for-the-badge&logo=twitter)](https://twitter.com/pranatpatel_)
[![LinkedIn](https://img.shields.io/badge/-linkedin-gray?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/pranaypatel512/)


### Find this project useful ? ❤️

- Support it by clicking the ⭐️ button on the upper right of this page. ✌️

### License

```
MIT License

Copyright (c) 2023 Pranay Patel

Permission is hereby granted, free of charge, to any person obtaining a 
copy of this software and associated documentation files (the "Software"), 
to deal in the Software without restriction, including without limitation 
the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Software, and to permit persons to whom the 
Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included 
in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN 
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
