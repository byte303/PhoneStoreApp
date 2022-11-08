package frog.company.phonestoreapp.database

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import frog.company.phonestoreapp.model.Cart
import frog.company.phonestoreapp.model.Details
import frog.company.phonestoreapp.model.HotStore
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class UtilsDb : ViewModel() {

    private var listHot: MutableLiveData<ArrayList<HotStore>?> = MutableLiveData()
    fun getListHot(): LiveData<ArrayList<HotStore>?> {
        return listHot
    }

    private var listSeller: MutableLiveData<ArrayList<HotStore>?> = MutableLiveData()
    fun getListSeller(): LiveData<ArrayList<HotStore>?> {
        return listSeller
    }

    private var details: MutableLiveData<Details?> = MutableLiveData()
    fun getDetails(): LiveData<Details?> {
        return details
    }

    private var cart: MutableLiveData<Cart?> = MutableLiveData()
    fun getCart(): LiveData<Cart?> {
        return cart
    }


    fun onSelectHot() {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://run.mocky.io/v3/654bd15e-b121-49ba-a588-960956b15175")
            .addHeader("Content-Type", "application/json")
            .get()
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("onSelectHot", e.message.toString())
                listHot.postValue(null)
                listSeller.postValue(null)
            }

            override fun onResponse(call: Call, response: Response) {
                try {
                    val strResponse = response.body!!.string()
                    val obj = JSONObject(strResponse)
                    Log.d("onSelectHot", strResponse)

                    val homeStore = obj.getJSONArray("home_store")
                    if(homeStore.length() > 0){
                        val list = Json.decodeFromString<ArrayList<HotStore>>(homeStore.toString())
                        listHot.postValue(list)
                    }else
                        listHot.postValue(null)

                    val bestSeller = obj.getJSONArray("best_seller")
                    if(homeStore.length() > 0){
                        val list = Json.decodeFromString<ArrayList<HotStore>>(bestSeller.toString())
                        listSeller.postValue(list)
                    }else
                        listSeller.postValue(null)

                } catch (ex : Exception){
                    Log.e("onSelectHot", ex.message.toString())
                    listHot.postValue(null)
                    listSeller.postValue(null)
                }
            }
        })
    }

    fun onSelectDetails() {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://run.mocky.io/v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5")
            .addHeader("Content-Type", "application/json")
            .get()
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("onSelectDetails", e.message.toString())
                details.postValue(null)
            }

            override fun onResponse(call: Call, response: Response) {
                try {
                    val strResponse = response.body!!.string()
                    val obj = JSONObject(strResponse)
                    Log.d("onSelectDetails", strResponse)

                    val element = Json.decodeFromString<Details>(obj.toString())
                    details.postValue(element)


                } catch (ex : Exception){
                    Log.e("onSelectDetails", ex.message.toString())
                    details.postValue(null)
                }
            }
        })
    }

    fun onSelectCart() {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://run.mocky.io/v3/53539a72-3c5f-4f30-bbb1-6ca10d42c149")
            .addHeader("Content-Type", "application/json")
            .get()
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("onSelectCart", e.message.toString())
                cart.postValue(null)
            }

            override fun onResponse(call: Call, response: Response) {
                try {
                    val strResponse = response.body!!.string()
                    val obj = JSONObject(strResponse)
                    Log.d("onSelectCart", strResponse)

                    val element = Json.decodeFromString<Cart>(obj.toString())
                    cart.postValue(element)


                } catch (ex : Exception){
                    Log.e("onSelectCart", ex.message.toString())
                    cart.postValue(null)
                }
            }
        })
    }
}