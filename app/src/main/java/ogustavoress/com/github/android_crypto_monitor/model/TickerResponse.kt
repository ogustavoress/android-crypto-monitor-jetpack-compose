package ogustavoress.com.github.android_crypto_monitor.model

import com.google.gson.annotations.SerializedName

data class TickerResponse(
    val ticker: Ticker
)

data class Ticker(
    val high: String,
    val low: String,
    val vol: String,
    val last: String,
    val buy: String,
    val sell: String,
    val open: String,
    val date: Long,
    val pair: String
)