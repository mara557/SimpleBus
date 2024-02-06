package com.example.simplebus.aPI

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://data.bus-data.dft.gov.uk/api/v1/dataset/?api_key=d3a4535d7faf5fbf95bd5fe87e670ab90028e332"

    val instance: BusApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(BusApiService::class.java)
    }
}
