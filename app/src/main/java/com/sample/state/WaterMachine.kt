package com.sample.state

/**
 * @author: lixin
 * Date: 2020/3/23
 * Description:
 */
class WaterMachine {
    var state: WaterMachineState
    val off = WaterMachineState.Off(this)
    val heating = WaterMachineState.Heating(this)
    val cooling = WaterMachineState.Cooling(this)

    init {
        this.state = off
    }

    fun turnHeating() {
        this.state.turnHeating()
    }

    fun turnCooling() {
        this.state.turnCooling()
    }

    fun turnOff() {
        this.state.turnOff()
    }
}