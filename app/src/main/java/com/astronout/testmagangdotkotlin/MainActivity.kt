package com.astronout.testmagangdotkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.astronout.testmagangdotkotlin.adapter.MalangAdapter
import com.astronout.testmagangdotkotlin.model.Malang
import com.astronout.testmagangdotkotlin.api.Service
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://info-malang-batu.firebaseapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Service::class.java)
        api.fetchAllItem().enqueue(object : Callback<List<Malang>>{
            override fun onResponse(call: Call<List<Malang>>, response: Response<List<Malang>>) {
                showData(response.body()!!)
            }

            override fun onFailure(call: Call<List<Malang>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun showData(malangs: List<Malang>){
        rv.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            adapter = MalangAdapter(malangs)
        }
    }
}
