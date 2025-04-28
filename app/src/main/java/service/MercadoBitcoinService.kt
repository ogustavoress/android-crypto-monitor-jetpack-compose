package service

import model.TicketResponse
import retrofit2.http.GET

class MercadoBitcoinService {
    @GET("api/BTC/ticker")
    suspend fun getTicker() Response<TickerResponse>{
    }
}