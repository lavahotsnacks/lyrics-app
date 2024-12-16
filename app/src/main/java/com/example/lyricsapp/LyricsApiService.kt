package com.example.lyricsapp

import retrofit2.http.GET
import retrofit2.http.Path

interface LyricsApiService {
    @GET("v1/{artist}/{title}")  // API endpoint format
    suspend fun getLyrics(
        @Path("artist") artist: String,  // Artist name parameter
        @Path("title") title: String  // Song title parameter
    ): LyricsResponse  // Return a LyricsResponse object containing the lyrics
}
