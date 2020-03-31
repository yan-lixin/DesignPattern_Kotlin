package com.sample.decorate

/**
 * @author: lixin
 * Date: 2020/3/23
 * Description:
 */
class Printer {
    fun drawLine() {
        println("------------")
    }

    fun drawDottedLine() {
        println("- - - - - - -")
    }

    fun drawStars() {
        println("************")
    }
}

fun Printer.startDraw(decorated: Printer.() -> Unit) {
    println("+++ start drawing +++")
    decorated()
    println("+++ end drawing +++")
}

fun main() {
    Printer().run {
        startDraw {
            drawLine()
        }
        startDraw {
            drawDottedLine()
        }
        startDraw {
            drawStars()
        }
    }
}