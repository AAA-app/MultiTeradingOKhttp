package com.aaa.multitradingokhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.aaa.multitradingokhttp.model.*
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main2.*
import okhttp3.*
import java.io.IOException


class NetworkActivity : AppCompatActivity() {
    private val TAG = "Main2Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btnStarJson = findViewById<Button>(R.id.button_start_json)

        btnStarJson.setOnClickListener {
            fetchJsonData1(text_view_json1)
            fetchJsonData2(text_view_json2)
            fetchJsonData3(text_view_json3)
            Log.d(TAG, "onCreate: onClick")
           return@setOnClickListener
        }
    }
    // connecting api ip for json 1
    private fun fetchJsonData1(text: TextView) {
        val url = "https://dog.ceo/api/breed/hound/list"
        val request = Request.Builder().url(url).build()
        val httpClient = OkHttpClient()
        val txtJson1 = text.findViewById<TextView>(R.id.text_view_json1)
        Log.d(TAG, "fetchJsonData1: Successful")

        httpClient.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                val gson = GsonBuilder().create()
                val ipData: DogResponse = gson.fromJson(body, DogResponse::class.java)

                runOnUiThread{txtJson1.text = ipData.toString() }.toString()
                Log.d(TAG, "onResponse: rabotaet")
            }
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute")
            }
        })
    }

    // connecting api ip for json 2
    private fun fetchJsonData2(text: TextView) {
        val url = "https://ipapi.co/json/"
        val request = Request.Builder().url(url).build()
        val httpClient = OkHttpClient()
        val txtJson2 = text.findViewById<TextView>(R.id.text_view_json2)

        httpClient.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                val gson = GsonBuilder().create()
                val ipData: IpCountry = gson.fromJson(body, IpCountry::class.java)

                runOnUiThread{txtJson2.text = ipData.toString()}.toString()
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute")
            }
        })
    }

    // connecting api ip for json 3
    private fun fetchJsonData3(text: TextView) {
        val base_url = "https://my-json-server.typicode.com/typicode/demo/posts/1"
        val request = Request.Builder().url(base_url).build()
        val httpClient = OkHttpClient()
        val txtJson3 = text.findViewById<TextView>(R.id.text_view_json3)

        httpClient.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                val gson = GsonBuilder().create()
                val ipData: UserData = gson.fromJson(body, UserData::class.java)

                runOnUiThread{txtJson3.text = ipData.toString()}.toString()
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute")
            }
        })
    }
}















