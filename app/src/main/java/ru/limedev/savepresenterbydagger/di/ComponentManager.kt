package ru.limedev.savepresenterbydagger.di

import android.content.Context
import ru.limedev.savepresenterbydagger.App

/**
 * Отвечает за хранение и удаление компонентов приложения и Activity Dagger.
 */
object ComponentManager {

    private lateinit var appContext: Context

    /**
     * Основной компонент.
     */
    private var appComponent: AppComponent? = null

    /**
     * Сабкомпонент основного компонента.
     */
    private var mainActivityComponent: MainActivityComponent? = null

    /**
     * Для инициализации в [App].
     */
    fun init(context: Context) {
        appContext = context
    }

    /**
     * @return [AppComponent] - основной компонент.
     */
    fun getAppComponent() = appComponent ?: DaggerAppComponent.builder()
        .appModule(AppModule(appContext))
        .build()
        .also {
            appComponent = it
        }

    /**
     * @return [MainActivityComponent] - сабкомпонент основного компонента.
     */
    fun getMainActivityComponent() = mainActivityComponent ?: getAppComponent()
        .plusMainActivityComponent()
        .also {
            mainActivityComponent = it
        }

    /**
     * Очищает [MainActivityComponent].
     */
    fun clearMainActivityComponent() {
        mainActivityComponent = null
    }
}