package com.sample.abs_factory

/**
 * @author: lixin
 * Date: 2020/3/31
 * Description:
 */
class DellFactory: AbstractFactory() {

    override fun produce(): Computer = Dell()

}

class AsusFactory: AbstractFactory() {

    override fun produce(): Computer = Asus()

}

class AcerFactory: AbstractFactory() {

    override fun produce(): Computer = Acer()

}