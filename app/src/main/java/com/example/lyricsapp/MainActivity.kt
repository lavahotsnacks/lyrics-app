package com.example.lyricsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.example.lyricsapp.ui.theme.LyricsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LyricsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    LyricsAppContent()
                }
            }
        }
    }
}

@Composable
fun LyricsAppContent() {
    // type inference - "" is string, makes code more concise
    // State variables to store song title, artist name, and lyrics.
    var songTitle by remember { mutableStateOf("") }
    var artistName by remember { mutableStateOf("") }
    var lyrics by remember { mutableStateOf("Enter song details above to fetch lyrics.") }

    // Create a coroutine scope that is remembered across recompositions.
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = songTitle,
            onValueChange = { songTitle = it },
            label = { Text("Song Title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = artistName,
            onValueChange = { artistName = it },
            label = { Text("Artist Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // extension function - separated the validation to make this code less mesier
                // Check if both song title and artist name are filled
                if (songTitle.isValidInput() && artistName.isValidInput()) {
                    coroutineScope.launch {
                        // Launch a coroutine to make a network call to fetch lyrics
                        try {
                            val response = ApiClient.retrofitService.getLyrics(artistName, songTitle)
                            // type casting - as? ensures this operation wont crash the app if the cast is invalid
                            // If the lyrics exist, set them. If not, show "No lyrics found."
                            lyrics = (response.lyrics as? String) ?: "No lyrics found."
                        } catch (e: Exception) {
                            lyrics = "Error fetching lyrics."
                        }
                    }
                } else {
                    // If fields are empty, show a prompt asking for both
                    lyrics = "Please enter both song title and artist."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Get Lyrics")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = lyrics,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth()
        )
    }
}