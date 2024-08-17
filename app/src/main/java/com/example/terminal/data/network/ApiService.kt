package com.example.terminal.data.network

import com.example.terminal.data.model.ResultDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET(
        "aggs/ticker/AAPL/range/{timeframe}/2022-01-09/2023-01-09?adjusted=true&sort=asc&limit"+
                "=50000&apiKey=Is6w5efIZ0AYP5cf1wBPQCo4Fo4LXobp"
    )
    suspend fun loadBars(
        @Path("timeframe") timeFrame: String
    ): ResultDto
}