package com.example.lyricsapp

// null safety - the lyrics might not be present for every song.
// data class - no need for additional behaviours, it only holds data.
data class LyricsResponse(
    val lyrics: String? = null
)