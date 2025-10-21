package ogustavoress.com.github.android_crypto_monitor.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import ogustavoress.com.github.android_crypto_monitor.service.MercadoBitcoinServiceFactory

data class TickerUiState(
    val valueText: String = "--",
    val dateText: String = "--/--/---- --:--:--",
    val loading: Boolean = false,
    val error: String? = null
)

class TickerViewModel : ViewModel() {
    var uiState by mutableStateOf(TickerUiState())
        private set

    private val service = MercadoBitcoinServiceFactory.create()

    fun refresh() {
        viewModelScope.launch {
            uiState = uiState.copy(loading = true, error = null)
            try {
                val tickerResponse = service.getTicker()
                val ticker = tickerResponse.ticker

                val lastValue = ticker.last.toDoubleOrNull() ?: 0.0
                val numberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
                val valueText = numberFormat.format(lastValue)

                val timeStamp = ticker.date
                val date = Date(timeStamp * 1000L)
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
                val dateText = sdf.format(date)

                uiState = uiState.copy(
                    valueText = valueText,
                    dateText = dateText,
                    loading = false
                    )
                } catch (e: Exception) {
                uiState = uiState.copy(
                    loading = false,
                    error = "Falha: ${e.message ?: "Erro desconhecido"}"
                )
            }
        }
    }
}
