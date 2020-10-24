package ktlint.standard

import ktlint.format
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class NoBlankLinesBeforeRBrace {

    @Test
    fun function() {

        val src = """
            fun main() {
                foo()
                bar()
                
            }
        """.trimIndent()

        val expected = """
            fun main() {
                foo()
                bar()
            }
        """.trimIndent()

        val actual = format(src)

        actual shouldBeEqualTo expected
    }

    @Test
    fun defineClass() {

        val src = """
            class Foo {
            
                fun foo() {
                    val a = "aaa"
                    val b = "bbb"
                    
                }
                
                private fun foo(): Int {
                    return 100
                }
                
            }
        """.trimIndent()

        val expected = """
            class Foo {
            
                fun foo() {
                    val a = "aaa"
                    val b = "bbb"
                }
            
                private fun foo(): Int {
                    return 100
                }
            }
        """.trimIndent()

        val actual = format(src)

        actual shouldBeEqualTo expected
    }

}