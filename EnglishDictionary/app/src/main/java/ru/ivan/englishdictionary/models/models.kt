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
    @Expose @SerializedName("text") val text: String?,
    @Expose @SerializedName("translation") val translation: Translation?
)

data class Definition(
    @Expose @SerializedName("soundUrl") val soundUrl: String?,
    @Expose @SerializedName("text") val text: String?
)

data class Example(
    @Expose @SerializedName("soundUrl") val soundUrl: String?,
    @Expose @SerializedName("text") val text: String?
)

data class Image(
    @Expose @SerializedName("url") val url: String?
)

data class MeaningsWithSimilarTranslation(
    @Expose @SerializedName("frequencyPercent") val frequencyPercent: String?,
    @Expose @SerializedName("meaningId") val meaningId: Int,
    @Expose @SerializedName("partOfSpeechAbbreviation") val partOfSpeechAbbreviation: String?,
    @Expose @SerializedName("translation") val translation: Translation?
)

class Properties(
)

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