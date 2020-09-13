package ru.ivan.englishdictionary.search.presenter.models


data class SearchItem(
    val id: Int,
    val partOfSpeechCode: String,
    val previewUrl: String,
    val transcription: String,
    val note: String,
    val text: String
)