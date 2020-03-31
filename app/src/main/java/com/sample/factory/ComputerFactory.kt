package com.sample.factory

/**
 * @author: lixin
 * Date: 2020/3/31
 * Description:
 */
object ComputerFactory {

    operator fun invoke(type: ComputerType): Computer {
        return when (type) {
            ComputerType.PC -> PC("")
            ComputerType.Server -> Server("")
        }
    }
}