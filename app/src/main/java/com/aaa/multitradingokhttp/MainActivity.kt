package com.aaa.multitradingokhttp


import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    internal var URL = "https://demonuts.com/Demonuts/JsonTest/Tennis/json_parsing.php"
    private val jsoncode = 1
    private var listView: ListView? = null
    private var playersModelArrayList: ArrayList<PlayersModel>? = null
    private var customeAdapter: CustomeAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lv) as ListView
        sampleKo()
    }

    private fun sampleKo() {
        try {
            Fuel.post(URL, listOf()).responseJson { request, response, result ->
                Log.d("plizzzzz", result.get().content)
                onTaskCompleted(result.get().content)
            }
        } catch (e: Exception) {

        } finally {

        }
    }


    private fun onTaskCompleted(response: String) {
        Log.d("responsejson", response)
        playersModelArrayList = getInfo(response)
        customeAdapter = CustomeAdapter(this, playersModelArrayList!!)
        listView!!.adapter = customeAdapter
    }

    private fun getInfo(response: String): ArrayList<PlayersModel> {
        val playersModelArrayList = ArrayList<PlayersModel>()
        try {
            val jsonObject = JSONObject(response)
            if (jsonObject.getString("status") == "true") {

                val dataArray = jsonObject.getJSONArray("data")

                for (i in 0 until dataArray.length()) {
                    val playersModel = PlayersModel()
                    val dataobj = dataArray.getJSONObject(i)
                    playersModel.setNames(dataobj.getString("name"))
                    playersModel.setCountrys(dataobj.getString("country"))
                    playersModel.setCitys(dataobj.getString("city"))
                    playersModelArrayList.add(playersModel)
                }
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return playersModelArrayList
    }

}



