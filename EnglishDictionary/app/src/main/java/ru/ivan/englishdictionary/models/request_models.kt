package ru.ivan.englishdictionary.models

import com.google.gson.annotations.SerializedName


class SearchRequestResult : ArrayList<SearchRequestResultItem>()

data class SearchRequestResultItem(
    @SerializedName("id") val id: Int,
    @SerializedName("meanings")val meanings: List<Meaning>,
    @SerializedName("text") val text: String
)

class FullInformationRequestResult : ArrayList<FullInformationRequestResultItem>()

data class FullInformationRequestResultItem(
    val alternativeTranslations: List<AlternativeTranslation>,
    val definition: Definition,
    val difficultyLevel: Any,
    val examples: List<Example>,
    val id: String,
    val images: List<Image>,
    val meaningsWithSimilarTranslation: List<MeaningsWithSimilarTranslation>,
    val mnemonics: Any,
    val partOfSpeechCode: String,
    val prefix: Any,
    val properties: Properties,
    val soundUrl: String,
    val text: String,
    val transcription: String,
    val translation: Translation,
    val updatedAt: String,
    val wordId: Int
)