package ogustavoress.com.github.android_crypto_monitor.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ogustavoress.com.github.android_crypto_monitor.viewModel.TickerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CryptoScreen(vm: TickerViewModel) {
    val state = vm.uiState

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cotação Bitcoin") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2C4EC7), // sua primária (#2C4EC7)
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Valor atual:", style = MaterialTheme.typography.titleMedium)
            Text(state.valueText, style = MaterialTheme.typography.displaySmall)
            Spacer(Modifier.height(12.dp))
            Text("Última atualização: ${state.dateText}")

            Spacer(Modifier.height(24.dp))

            if (state.error != null) {
                Text(
                    text = state.error ?: "",
                    color = MaterialTheme.colorScheme.error
                )
                Spacer(Modifier.height(8.dp))
            }

            Button(
                onClick = { vm.refresh() },
                enabled = !state.loading
            ) {
                Text(if (state.loading) "Atualizando..." else "Atualizar")
            }
        }
    }
}