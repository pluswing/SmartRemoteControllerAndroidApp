package jp.co.pluswing.smartremotecontrollerapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import jp.co.pluswing.smartremotecontrollerapp.databinding.IrDataViewBinding
import jp.co.pluswing.smartremotecontrollerapp.model.IrData

class IrDataAdapter(context: Context, items: List<IrData>) : ArrayAdapter<IrData>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val binding = if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            IrDataViewBinding.inflate(inflater, parent, false)
        } else {
            DataBindingUtil.getBinding(convertView)!!
        }

        binding.item = getItem(position)
        return binding.root
    }
}
