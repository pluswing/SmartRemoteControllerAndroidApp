package jp.co.pluswing.smartremotecontrollerapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import jp.co.pluswing.smartremotecontrollerapp.databinding.ActivityMainBinding
import jp.co.pluswing.smartremotecontrollerapp.model.IrData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext


class MainActivity : AppCompatActivity(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val vm = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        binding.vm = vm
        binding.lifecycleOwner = this

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(GitHubService::class.java)

        launch {
            val repos = service.listRepos("octocat")
            Log.d("ESP32APP", repos.toString())
        }

        vm.items.value = arrayListOf(
            IrData().apply {
                no = 1
                name = "あいうおえ"
            },
            IrData().apply {
                no = 2
                name = "かきくけこ"
            }
        )
    }

    override fun onPause() {
        job.cancel()
        super.onPause()
    }
}
