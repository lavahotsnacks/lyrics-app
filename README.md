# LyricsApp

LyricsApp is a simple Android application that allows users to search for and display song lyrics by entering the song title and artist name. The app fetches lyrics from the [Lyrics.ovh API](https://lyricsovh.docs.apiary.io/).

## Features

- **User-Friendly Interface**: A clean and responsive design with Material Design 3 components.
- **Real-Time Fetching**: Retrieves song lyrics in real-time using Retrofit.
- **Error Handling**: Provides user feedback for invalid input or network errors.

## Screenshots

<img width="493" alt="Screenshot 2024-12-16 at 5 14 01 PM" src="https://github.com/user-attachments/assets/3bf33b7f-8d01-458b-a598-247a8d228399" />

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/lyricsapp.git
   ```
2. Open the project in Android Studio.
3. Build and run the app on an emulator or a physical device.

## How It Works

1. Enter the song title and artist name in the input fields.
2. Tap the **Get Lyrics** button.
3. The app sends a network request to the Lyrics.ovh API to fetch the lyrics.
4. The lyrics are displayed in the app, or an error message is shown if the lyrics are not found.

## Project Structure

### Main Files

- `MainActivity.kt`: The main entry point of the app. Handles UI composition using Jetpack Compose and manages network requests.
- `ApiClient.kt`: Provides the Retrofit instance for network calls.
- `LyricsApiService.kt`: Defines the API interface for fetching lyrics.
- `LyricsResponse.kt`: Data class for the API response.
- `activity_main.xml` (if applicable): XML layout for legacy UI elements.

### Dependencies

- **Retrofit**: For making network requests.
- **Jetpack Compose**: For building the UI.
- **Gson**: For parsing JSON responses.

## Usage

1. Ensure your device or emulator has an active internet connection.
2. Launch the app.
3. Input a song title and artist name, then tap **Get Lyrics**.
4. View the lyrics or appropriate error messages.

## API Reference

- **Base URL**: `https://api.lyrics.ovh/`
- **Endpoint**: `GET /v1/{artist}/{title}`
  - **Parameters**:
    - `artist`: The name of the artist.
    - `title`: The title of the song.

Example request:
```bash
GET https://api.lyrics.ovh/v1/queen/bohemian_rhapsody
```

Response:
```json
{
  "lyrics": "Is this the real life? Is this just fantasy?..."
}
```

## Contributing

Contributions are welcome! If you'd like to contribute:

1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature-name
   ```
3. Make your changes and commit them:
   ```bash
   git commit -m "Add a new feature"
   ```
4. Push to the branch:
   ```bash
   git push origin feature-name
   ```
5. Create a pull request.

## License

This project does not include any specific license because it was created solely as part of a college assignment or academic project. It is intended for learning purposes and personal use only, and there are no formal permissions or restrictions granted for its use, modification, or distribution

## Acknowledgments

- [Lyrics.ovh API](https://lyricsovh.docs.apiary.io/): For providing the lyrics data.
- [Jetpack Compose](https://developer.android.com/jetpack/compose): For simplifying Android UI development.
