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

## Standard rules

|Rule|Format|Test|
|:-|:-:|:-:|
|Indentation formatting|o||
|No semicolons|o||
|No unused imports|o||
|No consecutive blank lines|o||
|No blank lines before }|o||
|No trailing whitespaces|o||
|No Unit returns|o||
|No empty ({}) class bodies|o||
|No wildcard imports|x||
|When wrapping chained calls ., ?. and ?: should be placed on the next line|o||
|When a line is broken at an assignment (=) operator the break comes after the symbol|o||
|When class/function signature doesn't fit on a single line, each parameter must be on a separate line|o||
|Consistent string templates|o||
|Consistent order of modifiers|o||
|Consistent spacing after keywords, commas; around colons, curly braces, parens, infix operators, comments, range operators, etc|o||
|Newline at the end of each file|o||
|Imports ordered consistently|o||

## Experimental rules

|Rule|Format|Test|
|:-|:-:|:-:|
|Annotation formatting|o||
|Annotations should be separated by the annotated declaration by a single line break|o||
|Argument list wrapping|o||
|Enum entry names should be uppercase underscore-separated names|o||
|Braces required for multiline if/else statements|o||
|No leading empty lines in method blocks|o||
|No underscores in package names|x||
|No spaces around angle brackets|o||
|No spaces around ::|o||
|No spaces around unary operators|o||
|Declarations with annotations should be separated by a blank line|o||
|Declarations with comments should be separated by a blank line|o||