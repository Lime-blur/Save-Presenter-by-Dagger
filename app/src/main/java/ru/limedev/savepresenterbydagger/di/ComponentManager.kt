package ru.limedev.savepresenterbydagger.di

import android.content.Context

object ComponentManager {

    private lateinit var appContext: Context
    private var appComponent: AppComponent? = null
    private var mainActivityComponent: MainActivityComponent? = null

    fun init(context: Context) {
        appContext = context
    }

    fun getAppComponent(): AppComponent =
        appComponent ?: DaggerAppComponent.builder()
            .appModule(AppModule(appContext))
            .build()
            .also {
                appComponent = it
            }

    fun clearAppComponent() {
        appComponent = null
        mainActivityComponent = null
    }

    fun getMainActivityComponent(): MainActivityComponent =
        mainActivityComponent ?: getAppComponent()
            .plusMainActivityComponent()
            .also {
                mainActivityComponent = it
            }

    fun clearMainActivityComponent() {
        mainActivityComponent = null
    }
}