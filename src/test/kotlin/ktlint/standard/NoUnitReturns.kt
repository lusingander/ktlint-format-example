package ktlint.standard

import ktlint.format
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class NoUnitReturns {

    @Test
    fun function() {

        val src = """
            fun foo(): Unit {
                val a = "aaa"
                val b = "bbb"
                return
            }
        """.trimIndent()

        val expected = """
            fun foo() {
                val a = "aaa"
                val b = "bbb"
                return
            }
        """.trimIndent()

        val actual = format(src)

        actual shouldBeEqualTo expected
    }

    @Test
    fun functionNoReturn() {

        val src = """
            fun foo(): Unit {
                val a = "aaa"
                val b = "bbb"
            }
        """.trimIndent()

        val expected = """
            fun foo() {
                val a = "aaa"
                val b = "bbb"
            }
        """.trimIndent()

        val actual = format(src)

        actual shouldBeEqualTo expected
    }

    @Test
    fun functionSingleExpression() {

        val src = """
            fun foo(): Unit = bar()
        """.trimIndent()

        val actual = format(src)

        actual shouldBeEqualTo src
    }
}