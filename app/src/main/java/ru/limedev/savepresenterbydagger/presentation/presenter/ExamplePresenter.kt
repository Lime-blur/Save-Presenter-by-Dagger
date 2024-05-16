package ru.limedev.savepresenterbydagger.presentation.presenter

import ru.limedev.savepresenterbydagger.data.ExampleModel
import ru.limedev.savepresenterbydagger.presentation.contract.ExampleContract
import ru.limedev.savepresenterbydagger.presentation.model.DataWrapper

class ExamplePresenter : ExampleContract.Presenter, ExampleContract.Model.OnFinishedListener {

    private var exampleView: ExampleContract.View? = null
    private var exampleModel = ExampleModel()
    private var data: DataWrapper? = null

    override fun attachView(view: ExampleContract.View) {
        this.exampleView = view
    }

    override fun detachView() {
        exampleView = null
    }

    override fun onCleared() {
        data = null
    }

    override fun requestDataFromServer() {
        if (data == null) {
            exampleModel.getData(this)
        } else {
            onFinished(data)
        }
    }

    override fun onFinished(dataWrapper: DataWrapper?) {
        if (dataWrapper != null) {
            data = dataWrapper
            exampleView?.setDataToView(dataWrapper)
        }
    }

    override fun onFailure(t: Throwable?) {
        exampleView?.onResponseFailure(t)
    }
}