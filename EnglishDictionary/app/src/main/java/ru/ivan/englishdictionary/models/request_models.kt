package ru.ivan.englishdictionary.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchRequestResultItem(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("meanings") val meanings: List<Meaning>,
    @Expose @SerializedName("text") val text: String
)


data class FullInformationRequestResultItem(
    @Expose @SerializedName("alternativeTranslations") val alternativeTranslations: List<AlternativeTranslation>?,
    @Expose @SerializedName("definition") val definition: Definition?,
    @Expose @SerializedName("difficultyLevel") val difficultyLevel: Int?,
    @Expose @SerializedName("examples") val examples: List<Example>?,
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("images") val images: List<Image>?,
    @Expose @SerializedName("meaningsWithSimilarTranslation") val meaningsWithSimilarTranslation: List<MeaningsWithSimilarTranslation>?,
    @Expose @SerializedName("mnemonics") val mnemonics: String?,
    @Expose @SerializedName("partOfSpeechCode") val partOfSpeechCode: String?,
    @Expose @SerializedName("prefix") val prefix: String?,
    @Expose @SerializedName("properties") val properties: Properties?,
    @Expose @SerializedName("soundUrl") val soundUrl: String?,
    @Expose @SerializedName("text") val text: String?,
    @Expose @SerializedName("transcription") val transcription: String?,
    @Expose @SerializedName("translation") val translation: Translation?,
    @Expose @SerializedName("updatedAt") val updatedAt: String?,
    @Expose @SerializedName("wordId") val wordId: Int
)