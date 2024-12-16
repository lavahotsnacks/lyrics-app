package com.example.lyricsapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://api.lyrics.ovh/"  // API base URL

    val retrofitService: LyricsApiService by lazy {
        // Set up Retrofit to handle network requests
        Retrofit.Builder()
            .baseUrl(BASE_URL)  // Set the base URL for API requests
            .addConverterFactory(GsonConverterFactory.create())  // Convert JSON responses into Kotlin objects
            .build()
            .create(LyricsApiService::class.java)  // Create the service to call the API
    }
}
