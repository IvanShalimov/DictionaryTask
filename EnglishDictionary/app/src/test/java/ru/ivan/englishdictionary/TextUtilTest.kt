package ru.ivan.englishdictionary

import org.junit.Test
import ru.ivan.englishdictionary.utils.text.TextUtil


class TextUtilTest {

    @Test
    fun `word with space`(){
        val validString = "  word "
        val noValidString = "     "
        val otherValidWordBreak = " long island  "

        val textUtil = TextUtil()
        assert(textUtil.isValidSearchKey(validString))
        assert(textUtil.isValidSearchKey(otherValidWordBreak))
        assert(!textUtil.isValidSearchKey(noValidString))
    }

    @Test
    fun `word with peculiar symbols`() {
        val validString = "word"
        val noValidString = "Hello!"

        val textUtil = TextUtil()
        assert(textUtil.isValidSearchKey(validString))
        assert(!textUtil.isValidSearchKey(noValidString))
    }

    @Test
    fun `course language`() {
        val validString = "sun"
        val noValidString = ".sun"
        val noValidStringToo = "dog"
        val textUtil = TextUtil()
        textUtil.badWords = listOf("dog","good","rain")
        assert(textUtil.isValidSearchKey(validString))
        assert(!textUtil.isValidSearchKey(noValidString))
        assert(!textUtil.isValidSearchKey(noValidStringToo))
    }
}
