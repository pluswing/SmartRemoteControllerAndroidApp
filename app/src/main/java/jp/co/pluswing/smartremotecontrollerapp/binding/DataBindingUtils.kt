package jp.co.pluswing.smartremotecontrollerapp.binding

import android.widget.ListView
import androidx.databinding.BindingAdapter
import jp.co.pluswing.smartremotecontrollerapp.model.IrData
import jp.co.pluswing.smartremotecontrollerapp.view.adapter.IrDataAdapter

object DataBindingUtils {

    @JvmStatic
    @BindingAdapter("ir_data")
    fun setIrDataAdapter(listView: ListView, items: List<IrData>) {

        if (listView.adapter == null) {
            listView.adapter = IrDataAdapter(listView.context, items)
        }

        (listView.adapter as IrDataAdapter).notifyDataSetChanged()
    }
}