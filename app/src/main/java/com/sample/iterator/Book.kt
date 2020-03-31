package com.sample.iterator

/**
 * @author: lixin
 * Date: 2020/3/31
 * Description:
 */
data class Book(val name: String)

class Bookcase(val books: List<Book>) {

    operator fun iterator(): Iterator<Book> = this.books.iterator()
}

operator fun Bookcase.iterator(): Iterator<Book> = object : Iterator<Book> {
    val iterator = books.iterator()

    override fun hasNext(): Boolean = iterator.hasNext()

    override fun next(): Book = iterator.next()

}