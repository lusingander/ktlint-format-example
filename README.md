# ktlint-format-example

Sample application that calls the [ktlint](https://github.com/pinterest/ktlint) formatter from the Kotlin source code

```kotlin
fun main() {
    val code = """
        class Foo(
        val id : String, val age : Int,
        val name:String )
        {
            fun foo() : Boolean { return name.isEmpty()
        }
        }
    """.trimIndent()

    val ruleSets = setOf(
        StandardRuleSetProvider().get()
    )
    val formatted = KtLint.format(
        KtLint.Params(
            fileName = null,
            text = code,
            ruleSets = ruleSets,
            userData = emptyMap(),
            cb = { _, _ -> run {} },
            script = false,
            editorConfigPath = null,
            debug = false
        )
    )

    println(formatted)
}

// Output:
//
// class Foo(
//     val id: String,
//     val age: Int,
//     val name: String
// ) {
//     fun foo(): Boolean {
//         return name.isEmpty()
//     }
// }
```
