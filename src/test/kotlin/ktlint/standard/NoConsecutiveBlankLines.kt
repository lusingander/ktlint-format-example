package ktlint.standard

import ktlint.format
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class NoConsecutiveBlankLines {

    @Test
    fun functions() {

        val src = """
            fun foo() = "foo"
            
            fun bar() {
                return "bar"
            }
            
            
            fun baz() {
                return "baz"
            }
        """.trimIndent()

        val expected = """
            fun foo() = "foo"
            
            fun bar() {
                return "bar"
            }
            
            fun baz() {
                return "baz"
            }
        """.trimIndent()

        val actual = format(src)

        actual shouldBeEqualTo expected
    }
}