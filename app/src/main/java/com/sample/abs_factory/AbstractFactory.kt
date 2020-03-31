package com.sample.abs_factory

/**
 * @author: lixin
 * Date: 2020/3/31
 * Description:
 */
abstract class AbstractFactory {
    abstract fun produce(): Computer

    companion object {
        inline operator fun <reified T: Computer> invoke(): AbstractFactory {
            return when (T::class) {
                Dell::class -> DellFactory()
                Asus::class -> AsusFactory()
                Acer::class -> AcerFactory()
                else -> throw IllegalArgumentException()
            }
        }
    }
}