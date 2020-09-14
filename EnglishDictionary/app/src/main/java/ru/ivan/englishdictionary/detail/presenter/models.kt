package ru.ivan.englishdictionary.detail.presenter

import ru.ivan.englishdictionary.models.PartOfSpeech

data class DetailInfo(
    val id: Int,
    val wordId: Int,
    val transcription: String,
    val text:String,
    val prefix: String,
    val mnemonics: String,
    val partOfSpeechCode: PartOfSpeech,
    val images: List<String>,
    val examples: List<String>,
    val difficultyLevel: Int,
    val definition: String,
    val noteTranslation:String,
    val textTranslation:String
)