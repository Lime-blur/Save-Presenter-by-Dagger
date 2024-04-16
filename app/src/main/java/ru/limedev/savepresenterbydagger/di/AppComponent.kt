package ru.limedev.savepresenterbydagger.di

import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class]
)
interface AppComponent {

    fun plusMainActivityComponent(): MainActivityComponent
}

@Module
class AppModule (private val context: Context) {

    @Singleton
    @Provides
    fun provideContext(): Context = context
}