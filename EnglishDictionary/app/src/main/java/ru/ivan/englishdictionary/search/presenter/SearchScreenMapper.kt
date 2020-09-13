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
    NOUN("n") {
        override fun getStringName() = "noun"
    },
    VERB("v") {
        override fun getStringName() = "verb"
    },
    ADJECTIVE("j") {
        override fun getStringName() = "adjective"
    },
    ADVERB("r"){ override fun getStringName() = "adverb" },
    PREPOSITION("prp"){ override fun getStringName() = "preposition" },
    PRONOUN("prn"){ override fun getStringName() = "pronoun" },
    CARDINAL_NUMBER("crd"){ override fun getStringName() = "cardinal number" },
    CONJUNCTION("cjc"){ override fun getStringName() = "conjunction" },
    INTERJECTION("exc"){ override fun getStringName() = "interjection" },
    ARTICLE("det"){ override fun getStringName() = "article" },
    ABBREVIATION("abb"){ override fun getStringName() = "abbreviation" },
    PARTICLE("x"){ override fun getStringName() = "particle" },
    ORDINAL_NUMBER("ord"){ override fun getStringName() = "ordinal number" },
    MODAL_VERB("md"){ override fun getStringName() = "modal verb" },
    PHRASE("ph"){ override fun getStringName() = "phrase" },
    IDIOM("phi"){ override fun getStringName() = "idiom" },
    UNDEFINED("und"){ override fun getStringName() = "undefined" };

    abstract fun getStringName(): String
}