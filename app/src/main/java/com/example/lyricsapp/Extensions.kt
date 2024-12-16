package com.example.lyricsapp

// extension function - to add validation functionality to strings without cluttering the main code
// Validate if a string is not empty
fun String.isValidInput(): Boolean = this.isNotEmpty()