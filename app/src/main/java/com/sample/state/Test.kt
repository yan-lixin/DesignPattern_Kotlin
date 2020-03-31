package com.sample.state

/**
 * @author: lixin
 * Date: 2020/3/23
 * Description:
 */

enum class Moment {
    EARLY_MORNING,
    DRINKING_WATER,
    INSTANCE_NOODLES,
    AFTER_WORK
}

fun waterMachineOps(machine: WaterMachine, moment: Moment) {
    when (moment) {
        Moment.EARLY_MORNING, Moment.DRINKING_WATER -> when (machine.state) {
            !is WaterMachineState.Cooling -> machine.turnCooling()
        }
        Moment.INSTANCE_NOODLES -> when (machine.state) {
            !is WaterMachineState.Heating -> machine.turnHeating()
        }
        Moment.AFTER_WORK -> when (machine.state) {
            !is WaterMachineState.Off -> machine.turnOff()
        }
    }
}

fun main() {
    val machine = WaterMachine()
    waterMachineOps(machine, Moment.EARLY_MORNING)
    waterMachineOps(machine, Moment.INSTANCE_NOODLES)
    waterMachineOps(machine, Moment.DRINKING_WATER)
    waterMachineOps(machine, Moment.AFTER_WORK)
}
