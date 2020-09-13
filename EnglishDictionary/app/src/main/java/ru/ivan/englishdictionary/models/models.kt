package ru.ivan.englishdictionary.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Meaning(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("imageUrl") val imageUrl: String,
    @Expose @SerializedName("partOfSpeechCode") val partOfSpeechCode: String,
    @Expose @SerializedName("previewUrl") val previewUrl: String?,
    @Expose @SerializedName("soundUrl") val soundUrl: String?,
    @Expose @SerializedName("transcription") val transcription: String?,
    @Expose @SerializedName("translation") val translation: Translation?
)

data class Translation(
    @Expose @SerializedName("note") val note: String?,
    @Expose @SerializedName("text") val text: String?
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