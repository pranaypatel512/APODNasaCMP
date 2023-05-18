import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.pranay.aPODNasaKMP.MainView
import com.pranay.aPODNasaKMP.di.koinInit

fun main() = application {
    koinInit()
    Window(
        title = "APODNasaKMP",
        state = rememberWindowState(width = 1200.dp, height = 800.dp),
        onCloseRequest = ::exitApplication,
    ) {
        MainView()
    }
}
