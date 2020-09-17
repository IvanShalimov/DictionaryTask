package ru.ivan.englishdictionary.utils.text

class TextUtil {
    fun isValidSearchKey(searchWord:String): Boolean{
        if(searchWord.trim().isEmpty()) {
            return false
        }
        if(searchWord.indexOfAny(charArrayOf('.', '$', '!')) >= 0) {
            return false
        }

        return containBadWord(searchWord).isNullOrBlank()
    }

    private fun containBadWord(searchWord:String): String? {
        return badWords.firstOrNull{
            searchWord.contains(it)}
    }

    var badWords = listOf<String>()
}