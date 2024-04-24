package com.danny.bmi

class Bmi(val weight: Float, val height: Float) {

    fun bmi(): Float {
        return weight / (height * height)
    }

    override fun toString(): String {
        return bmi().toString()
    }
}


