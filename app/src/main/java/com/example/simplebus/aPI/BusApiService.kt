package com.example.simplebus.aPI

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BusApiService {

    @GET("dataset/")
    fun getTimetables(
        @Query("api_key") apiKey: String,
        @Query("adminArea") adminArea: String?,
        // Add other query parameters as needed
    ): Call<List<BusData>>

    // Add other API methods if needed

    @GET("datafeed/")
    fun getBusLocation(
        @Query("api_key") apiKey: String,
        @Query("boundingBox") boundingBox: String?,
        // Add other query parameters as needed
    ): Call<List<BusData>>

    @GET("fares/dataset/")
    fun getFares(
        @Query("api_key") apiKey: String,
        @Query("noc") noc: String?,
        // Add other query parameters as needed
    ): Call<List<BusData>>
}
