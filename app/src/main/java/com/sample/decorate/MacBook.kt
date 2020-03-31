package com.sample.decorate

/**
 * @author: lixin
 * Date: 2020/3/23
 * Description:
 */
interface MacBook {
    fun getCost(): Int
    fun getDesc(): String
    fun getProdDate(): String
}

class MackBookPro: MacBook {

    override fun getCost(): Int = 10000

    override fun getDesc(): String = "MacBook Pro"

    override fun getProdDate(): String = "Late 2020"

}

class ProcessorUpgradeMacBookPro(private val macBook: MacBook): MacBook by macBook {

    override fun getCost(): Int = macBook.getCost() + 200

    override fun getDesc(): String = macBook.getDesc() + ", +1G Memory"

}

fun main() {
    val mackBookPro = MackBookPro()
    val processorUpgradeMacBookPro = ProcessorUpgradeMacBookPro(mackBookPro)
    println(processorUpgradeMacBookPro.getCost())
    println(processorUpgradeMacBookPro.getDesc())
}