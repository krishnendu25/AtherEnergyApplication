package com.atherenergyassignment

import android.app.Application

class AtherEnergyApplication : Application() {

    init {
        instance = this
    }
    companion object {
        private var instance: AtherEnergyApplication? = null
        @Synchronized
        fun applicationContext(): AtherEnergyApplication {
            return instance as AtherEnergyApplication
        }
    }
}