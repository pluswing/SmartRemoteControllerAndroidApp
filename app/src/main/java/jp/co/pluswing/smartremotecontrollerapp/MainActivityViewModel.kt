package jp.co.pluswing.smartremotecontrollerapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jp.co.pluswing.smartremotecontrollerapp.model.IrData

class MainActivityViewModel : ViewModel() {

    val title = MutableLiveData<String>("あいうえお")
    val items = MutableLiveData<List<IrData>>(listOf())

    fun click() {
        Log.d("TEST", title.value)
        Log.d("TEST", "clicked!")
    }

    fun changeValue() {
        title.value = "かきくけこ"
    }
}
