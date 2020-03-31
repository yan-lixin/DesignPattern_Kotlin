package com.sample.type

/**
 * @author: lixin
 * Date: 2020/3/23
 * Description:
 */

interface Kind<out F, out A>

interface Functor<F> {
    fun <A, B> Kind<F, A>.map(f: (A) -> B): Kind<F, B>
}

sealed class List<out A> : Kind<List.K, A> {
    object K
}

object Nil : List<Nothing>()

data class Cons<A>(val head: A, val tail: List<A>) : List<A>()

inline fun <A> Kind<List.K, A>.upwarp(): List<A> = this as List<A>

object ListFunctor : Functor<List.K> {

    override fun <A, B> Kind<List.K, A>.map(f: (A) -> B): Kind<List.K, B> {
        return when (this) {
            is Cons -> {
                val t = this.tail.map(f).upwarp()
                Cons<B>(f(this.head), t)
            }
            else -> Nil
        }
    }

}

fun main() {
    ListFunctor.run {
        Cons(1, Nil).map {
            it + 1
        }
    }
}