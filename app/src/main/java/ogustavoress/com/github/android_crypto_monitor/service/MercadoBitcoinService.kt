package ogustavoress.com.github.android_crypto_monitor.service

import ogustavoress.com.github.android_crypto_monitor.model.TickerResponse
import retrofit2.http.GET

interface MercadoBitcoinService {
    @GET("api/BTC/ticker/")
    suspend fun getTicker(): TickerResponse
}