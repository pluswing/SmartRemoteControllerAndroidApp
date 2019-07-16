package jp.co.pluswing.smartremotecontrollerapp

import android.util.Log
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    var title = "あいうえお"

    fun click() {
        Log.d("TEST", title)
        Log.d("TEST", "clicked!")
    }
}