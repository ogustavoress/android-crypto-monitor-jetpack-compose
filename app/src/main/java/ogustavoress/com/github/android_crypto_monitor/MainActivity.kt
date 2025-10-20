package ogustavoress.com.github.android_crypto_monitor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import ogustavoress.com.github.android_crypto_monitor.ui.screen.CryptoScreen
import ogustavoress.com.github.android_crypto_monitor.ui.theme.AndroidCryptoMonitorTheme
import ogustavoress.com.github.android_crypto_monitor.viewModel.TickerViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCryptoMonitorTheme {
                val vm: TickerViewModel = viewModel()
                CryptoScreen(vm)
            }
        }
    }
}