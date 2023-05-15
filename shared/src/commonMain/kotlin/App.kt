import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter
import org.jetbrains.compose.resources.ExperimentalResourceApi


// Declare your screen configurations for type-safety
@Parcelize
sealed class Screen: Parcelable {
    object List : Screen()
    data class Details(val detail: String) : Screen()
}

@Composable
fun App() {
    APODNasaKMPTheme {
        Surface(color = MaterialTheme.colors.surface) {
            // Create a router with a stack of screen configurations 🚏
            val router: Router<Screen> = rememberRouter(Screen::class, listOf(Screen.List))

            // Hoist your screens for each configuration 🏗️
            RoutedContent(router = router) { screen ->
                when (screen) {
                    Screen.List -> HomeScreen(
                        // Navigate by pushing new configurations on the router 🧭
                        onSelectItem = { detail -> router.push(Screen.Details(detail)) }
                    )

                    is Screen.Details -> DetailsScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen(onSelectItem : (String) -> Unit ) {
    Text("HomeScreen", color = Blue70, modifier = Modifier.clickable {
        onSelectItem.invoke("Test")
    })
}
@Composable
fun DetailsScreen(){
    Text("DetailsScreen", color = Blue70, modifier = Modifier.clickable {
    })
}



expect fun getPlatformName(): String