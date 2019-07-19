package jp.co.pluswing.smartremotecontrollerapp.api

import android.content.Context
import jp.co.pluswing.smartremotecontrollerapp.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object IrApi {

    fun client(context: Context): IrService {
        val retrofit = Retrofit.Builder()
            .baseUrl(context.getString(R.string.ir_api_endpoint))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(IrService::class.java)
    }
}