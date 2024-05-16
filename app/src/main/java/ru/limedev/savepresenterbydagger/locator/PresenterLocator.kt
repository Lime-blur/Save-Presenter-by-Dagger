package ru.limedev.savepresenterbydagger.locator

import ru.limedev.savepresenterbydagger.presentation.contract.ExampleContract
import ru.limedev.savepresenterbydagger.presentation.presenter.ExamplePresenter

object PresenterLocator {

    private var examplePresenter: ExampleContract.Presenter? = null

    fun getExamplePresenter(): ExampleContract.Presenter {
        return examplePresenter ?: run {
            val presenter = ExamplePresenter()
            examplePresenter = presenter
            presenter
        }
    }

    fun destroyPresenter() {
        examplePresenter = null
    }
}