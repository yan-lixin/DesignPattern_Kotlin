package com.sample.state

/**
 * @author: lixin
 * Date: 2020/3/23
 * Description:
 */
sealed class WaterMachineState(open val machine: WaterMachine) {
    fun turnHeating() {
        if (this !is Heating) {
            println("turn heating")
            machine.state = machine.heating
        } else {
            println("The state is already heating mode.")
        }
    }

    fun turnCooling() {
        if (this !is Cooling) {
            println("turn cooling")
            machine.state = machine.cooling
        } else {
            println("The state is already cooling mode.")
        }
    }

    fun turnOff() {
        if (this !is Off) {
            println("turn off")
            machine.state = machine.off
        } else {
            println("The state is already off mode.")
        }
    }

    class Off(override val machine: WaterMachine): WaterMachineState(machine)
    class Heating(override val machine: WaterMachine): WaterMachineState(machine)
    class Cooling(override val machine: WaterMachine): WaterMachineState(machine)
}