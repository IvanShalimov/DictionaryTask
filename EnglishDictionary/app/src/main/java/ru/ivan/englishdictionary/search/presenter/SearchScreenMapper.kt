package ru.ivan.englishdictionary.search.presenter

import ru.ivan.englishdictionary.models.Meaning
import ru.ivan.englishdictionary.search.presenter.models.SearchItem

class SearchScreenMapper {
    fun map(meanings: List<Meaning>) = meanings.map { map(it) }

    private fun map(meaning: Meaning): SearchItem {
        return SearchItem(
            id = meaning.id,
            partOfSpeechCode = PartOfSpeech.values()
                .firstOrNull { it.code == meaning.partOfSpeechCode } ?: PartOfSpeech.UNDEFINED,
            previewUrl = meaning.previewUrl ?: "",
            transcription = meaning.transcription ?: "",
            note = meaning.translation?.note ?: "",
            text = meaning.translation?.text ?: ""
        )
    }
}

enum class PartOfSpeech(val code: String) {
    NOUN("n"),
    VERB("v"),
    ADJECTIVE("j"),
    ADVERB("r"),
    PREPOSITION("prp"),
    PRONOUN("prn"),
    CARDINAL_NUMBER("crd"),
    CONJUNCTION("cjc"),
    INTERJECTION("exc"),
    ARTICLE("det"),
    ABBREVIATION("abb"),
    PARTICLE("x"),
    ORDINAL_NUMBER("ord"),
    MODAL_VERB("md"),
    PHRASE("ph"),
    IDIOM("phi"),
    UNDEFINED("und")
}