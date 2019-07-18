package jp.co.pluswing.smartremotecontrollerapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    val title = MutableLiveData<String>("あいうえお")

    fun click() {
        Log.d("TEST", title.value)
        Log.d("TEST", "clicked!")
    }

    fun changeValue() {
        title.value = "かきくけこ"
    }
}
