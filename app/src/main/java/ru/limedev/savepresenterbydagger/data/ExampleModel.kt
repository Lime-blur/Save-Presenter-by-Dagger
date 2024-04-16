package ru.limedev.savepresenterbydagger.data

import ru.limedev.savepresenterbydagger.presentation.contract.ExampleContract
import ru.limedev.savepresenterbydagger.presentation.model.DataWrapper
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ExampleModel: ExampleContract.Model {

    override fun getData(onFinishedListener: ExampleContract.Model.OnFinishedListener?) {
        val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault())
        val calendar = Calendar.getInstance()
        val time = dateFormat.format(calendar.time)
        onFinishedListener?.onFinished(
            DataWrapper("Hello world! Current time: $time")
        )
    }
}