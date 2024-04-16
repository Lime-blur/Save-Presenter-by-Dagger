package ru.limedev.savepresenterbydagger.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.limedev.savepresenterbydagger.R
import ru.limedev.savepresenterbydagger.di.ComponentManager
import ru.limedev.savepresenterbydagger.presentation.contract.ExampleContract
import ru.limedev.savepresenterbydagger.presentation.model.DataWrapper
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ExampleContract.View {

    @Inject
    lateinit var examplePresenter: ExampleContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPresenterView()
        requestData()
    }

    override fun onDestroy() {
        super.onDestroy()
        examplePresenter.detachView()
        if (isFinishing) {
            examplePresenter.onCleared()
            ComponentManager.clearMainActivityComponent()
        }
    }

    override fun setDataToView(dataWrapper: DataWrapper) {
        findViewById<TextView>(R.id.textView).text = dataWrapper.data
    }

    override fun onResponseFailure(throwable: Throwable?) { throwable?.printStackTrace() }

    private fun injectDependencies() {
        ComponentManager.getMainActivityComponent()
            .inject(this)
    }

    private fun initPresenterView() {
        examplePresenter.attachView(this)
    }

    private fun requestData() {
        examplePresenter.requestDataFromServer()
    }
}