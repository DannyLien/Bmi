package com.danny.bmi

class Bmi(val weight: Float, val height: Float) {

    fun bmi(): Float {
        return weight / (height * height)
    }

}