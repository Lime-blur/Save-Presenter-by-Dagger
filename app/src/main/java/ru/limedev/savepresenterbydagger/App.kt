package ru.limedev.savepresenterbydagger

import android.app.Application
import ru.limedev.savepresenterbydagger.di.ComponentManager

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ComponentManager.init(this)
    }
}