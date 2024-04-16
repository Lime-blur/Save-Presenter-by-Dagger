package ru.limedev.savepresenterbydagger.presentation.contract

import ru.limedev.savepresenterbydagger.presentation.model.DataWrapper

interface ExampleContract {

    interface Model {
        interface OnFinishedListener {
            fun onFinished(dataWrapper: DataWrapper?)
            fun onFailure(t: Throwable?)
        }
        fun getData(onFinishedListener: OnFinishedListener?)
    }

    interface View {
        fun setDataToView(dataWrapper: DataWrapper)
        fun onResponseFailure(throwable: Throwable?)
    }

    interface Presenter {
        fun attachView(view: View)
        fun detachView()
        fun onCleared()
        fun requestDataFromServer()
    }
}