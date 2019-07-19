package jp.co.pluswing.smartremotecontrollerapp.activity.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jp.co.pluswing.smartremotecontrollerapp.model.IrData

class MainActivityViewModel : ViewModel() {

    val title = MutableLiveData<String>("あいうえお")
    val items = MutableLiveData<ArrayList<IrData>>(arrayListOf())

    fun click() {
        Log.d("TEST", title.value)
        Log.d("TEST", "clicked!")
    }

    fun changeValue() {
        title.value = "かきくけこ"
        items.value!!.add(IrData().apply {
            no = 3
            name = "ついか"
        })
        items.value = items.value
    }
}
