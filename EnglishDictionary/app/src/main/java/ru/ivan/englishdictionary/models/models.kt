package ru.ivan.englishdictionary.models

data class Meaning(
    val id: Int,
    val imageUrl: String,
    val partOfSpeechCode: String,
    val previewUrl: String,
    val soundUrl: String,
    val transcription: String,
    val translation: Translation
)

data class Translation(
    val note: String,
    val text: String
)

data class AlternativeTranslation(
    val text: String,
    val translation: Translation
)

data class Definition(
    val soundUrl: String,
    val text: String
)

data class Example(
    val soundUrl: String,
    val text: String
)

data class Image(
    val url: String
)

data class MeaningsWithSimilarTranslation(
    val frequencyPercent: String,
    val meaningId: Int,
    val partOfSpeechAbbreviation: String,
    val translation: Translation
)

class Properties(
)