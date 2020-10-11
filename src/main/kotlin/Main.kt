@file:JvmName("Main")

package com.example

import com.pinterest.ktlint.core.KtLint
import com.pinterest.ktlint.ruleset.standard.StandardRuleSetProvider

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
    val userData = mapOf(
        "android" to true.toString()
    )
    val formatted = KtLint.format(
        KtLint.Params(
            fileName = null,
            text = code,
            ruleSets = ruleSets,
            userData = userData,
            cb = { _, _ -> run {} },
            script = false,
            editorConfigPath = null,
            debug = false
        )
    )

    println(formatted)
}