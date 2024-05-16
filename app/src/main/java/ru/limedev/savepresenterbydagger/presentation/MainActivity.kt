package ru.limedev.savepresenterbydagger.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.limedev.savepresenterbydagger.R
import ru.limedev.savepresenterbydagger.locator.PresenterLocator
import ru.limedev.savepresenterbydagger.presentation.contract.ExampleContract
import ru.limedev.savepresenterbydagger.presentation.model.DataWrapper

class MainActivity : AppCompatActivity(), ExampleContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPresenterView()
        requestData()
    }

    override fun onDestroy() {
        super.onDestroy()
        PresenterLocator.getExamplePresenter().detachView()
        if (isFinishing) {
            PresenterLocator.getExamplePresenter().onCleared()
            PresenterLocator.destroyPresenter()
        }
    }

    override fun setDataToView(dataWrapper: DataWrapper) {
        findViewById<TextView>(R.id.textView).text = dataWrapper.data
    }

    override fun onResponseFailure(throwable: Throwable?) { throwable?.printStackTrace() }

    private fun initPresenterView() {
        PresenterLocator.getExamplePresenter().attachView(this)
    }

    private fun requestData() {
        PresenterLocator.getExamplePresenter().requestDataFromServer()
    }
}