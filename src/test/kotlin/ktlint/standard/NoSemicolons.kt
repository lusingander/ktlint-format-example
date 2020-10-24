package ktlint.standard

import ktlint.format
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class NoSemicolons {

    @Test
    fun defineVariables() {

        val src = """
            fun main() {
                val foo: Int = 10;
                var bar = "baz";
            }
        """.trimIndent()

        val expected = """
            fun main() {
                val foo: Int = 10
                var bar = "baz"
            }
        """.trimIndent()

        val actual = format(src)

        actual shouldBeEqualTo expected
    }

    @Test
    fun callFunctions() {

        val src = """
            fun main() {
                foo();
                bar.baz();
            }
        """.trimIndent()

        val expected = """
            fun main() {
                foo()
                bar.baz()
            }
        """.trimIndent()

        val actual = format(src)

        actual shouldBeEqualTo expected
    }
}