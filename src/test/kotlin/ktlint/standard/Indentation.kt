package ktlint.standard

import ktlint.format
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class Indentation {

    @Test
    fun primaryConstructor() {

        val src = """
            data class C(val a: Any,
                         val b: Any = 0,
                         val c: Any)
        """.trimIndent()

        val expected = """
            data class C(
                val a: Any,
                val b: Any = 0,
                val c: Any
            )
        """.trimIndent()

        val actual = format(src)

        actual shouldBeEqualTo expected
    }
}