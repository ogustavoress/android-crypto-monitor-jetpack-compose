package ogustavoress.com.github.android_crypto_monitor.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MercadoBitcoinServiceFactory {

    fun create(): MercadoBitcoinService {
        return Retrofit.Builder()
            .baseUrl("https://www.mercadobitcoin.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MercadoBitcoinService::class.java)
    }
}
