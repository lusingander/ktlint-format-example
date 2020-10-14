package ktlint

import com.pinterest.ktlint.core.KtLint
import com.pinterest.ktlint.ruleset.experimental.ExperimentalRuleSetProvider
import com.pinterest.ktlint.ruleset.standard.StandardRuleSetProvider

fun format(s: String, experimental: Boolean = false): String {

    val ruleSets = mutableSetOf(
        StandardRuleSetProvider().get()
    )
    if (experimental) {
        ruleSets.add(
            ExperimentalRuleSetProvider().get()
        )
    }

    val userData = mapOf(
        "android" to true.toString()
    )

    val formatted = KtLint.format(
        KtLint.Params(
            fileName = null,
            text = s,
            ruleSets = ruleSets,
            userData = userData,
            cb = { _, _ -> run {} },
            script = false,
            editorConfigPath = null,
            debug = false
        )
    )

    return formatted.trimEnd()
}
