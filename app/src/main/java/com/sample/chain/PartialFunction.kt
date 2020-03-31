package com.sample.chain

/**
 * @author: lixin
 * Date: 2020/3/23
 * Description: 偏函数式责任链
 */
class PartialFunction<in P1, out R>(
    private val defineAt: (P1) -> Boolean,
    private val f: (P1) -> R
) : (P1) -> R {

    override fun invoke(p1: P1): R {
        if (defineAt(p1)) {
            return f(p1)
        } else {
            throw IllegalArgumentException()
        }
    }

    fun isDefinedAt(p1: P1) = defineAt(p1)

}

infix fun <P1, R> PartialFunction<P1, R>.orElse(that: PartialFunction<P1, R>): PartialFunction<P1, R> {
    return PartialFunction(
        { this.isDefinedAt(it) || that.isDefinedAt(it) },
        {
            when {
                this.isDefinedAt(it) -> this(it)
                else -> that(it)
            }
        }
    )
}

val groupLeader = {
    val defineAt: (ApplyEvent) -> Boolean = { it.money <= 200 }
    val handler: (ApplyEvent) -> Unit = { println("GroupLeader handled application: ${it.title}.") }
    PartialFunction(defineAt, handler)
}()

val president = {
    val defineAt: (ApplyEvent) -> Boolean = { it.money <= 500 }
    val handler: (ApplyEvent) -> Unit = { println("President handled application: ${it.title}.") }
    PartialFunction(defineAt, handler)
}()

val college = {
    val defineAt: (ApplyEvent) -> Boolean = { true }
    val handler: (ApplyEvent) -> Unit = {
        when {
            it.money > 1000 -> println("College: This application is refused.")
            else -> println("College handled application: ${it.title}.")
        }
    }
    PartialFunction(defineAt, handler)
}()

fun main() {
    val applyChain = groupLeader orElse president orElse college
    applyChain(ApplyEvent(600, "hold a debate match"))
}