package ru.ivan.englishdictionary.search.presenter.models

import ru.ivan.englishdictionary.models.PartOfSpeech


data class SearchItem(
    val id: Int,
    val partOfSpeechCode: PartOfSpeech,
    val previewUrl: String,
    val transcription: String,
    val note: String,
    val text: String
)