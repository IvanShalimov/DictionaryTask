package ru.ivan.englishdictionary.detail.presenter

import ru.ivan.englishdictionary.models.FullInformationRequestResultItem
import ru.ivan.englishdictionary.models.PartOfSpeech

class DetailMapper {
    fun map(fullInformationRequestResultItem: FullInformationRequestResultItem): DetailInfo {
        return DetailInfo(id = fullInformationRequestResultItem.id,
            wordId = fullInformationRequestResultItem.wordId,
            transcription = fullInformationRequestResultItem.transcription ?: "",
            text = fullInformationRequestResultItem.text ?: "",
            prefix = fullInformationRequestResultItem.prefix ?: "",
            mnemonics = fullInformationRequestResultItem.mnemonics ?: "",
            images = fullInformationRequestResultItem.images?.map { it.url ?: "" }
                ?: listOf(),
            examples = fullInformationRequestResultItem.examples?.map { it.text ?: "" }
                ?: listOf(),
            difficultyLevel = fullInformationRequestResultItem.difficultyLevel ?: -1,
            definition = fullInformationRequestResultItem.definition?.text ?: "",
            noteTranslation = fullInformationRequestResultItem.translation?.note ?: "",
            textTranslation = fullInformationRequestResultItem.translation?.text ?: "",
            partOfSpeechCode = PartOfSpeech.values()
                .firstOrNull { it.code == fullInformationRequestResultItem.partOfSpeechCode }
                ?: PartOfSpeech.UNDEFINED)
    }
}