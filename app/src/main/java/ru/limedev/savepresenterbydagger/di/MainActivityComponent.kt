package ru.limedev.savepresenterbydagger.di

import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import ru.limedev.savepresenterbydagger.presentation.MainActivity
import ru.limedev.savepresenterbydagger.presentation.contract.ExampleContract
import ru.limedev.savepresenterbydagger.presentation.presenter.ExamplePresenter
import javax.inject.Scope

@Scope
@Retention
annotation class ActivityScope

@ActivityScope
@Subcomponent(
    modules = [
        MainActivityModule::class,
        BindsPresenterModule::class
    ]
)
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}

@Module
class MainActivityModule

@Module
interface BindsPresenterModule {

    @Binds
    fun providePresenter(impl: ExamplePresenter): ExampleContract.Presenter
}