package com.example.cosscan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cosscan.databinding.ActivityMainBinding
import com.example.cosscan.databinding.ActivityProductBinding
import com.google.gson.Gson
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class ProductActivity : AppCompatActivity() {
    private lateinit var myDBHelper1: MyDBHelper1
    private lateinit var myDBHelper: MyDBHelper

    private lateinit var binding: ActivityMainBinding
    private var gbp_list: ArrayList<String> = ArrayList()
    private var fav: ArrayList<String> = ArrayList()
    private var least: ArrayList<String> = ArrayList()
    private var dd:String = String()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        myDBHelper1 = MyDBHelper1(this)
        myDBHelper = MyDBHelper(this)
        setContentView(binding.root)
        val k =""
        val message = intent.getStringExtra("EXTRA_MESSAGE")
        fetchCurrencyData().start()


        }
        private fun fetchCurrencyData(): Thread{
            return Thread {
                val a = "https://world.openbeautyfacts.org/api/v0/product/"
                val b = intent.getStringExtra("EXTRA_MESSAGE")
                val c = ".json"
                val d =  a.plus(b).plus(c)
                val url = URL(d)
                val connection = url.openConnection() as HttpsURLConnection
                if(connection.responseCode == 200){
                    val inputSystem = connection.inputStream
                    val inputStreamReader = InputStreamReader(inputSystem, "UTF-8")
                    val request = Gson().fromJson(inputStreamReader, Request::class.java)
                    updateUI(request)

                    inputStreamReader.close()
                    inputSystem.close()


                }
                else
                {
                    binding.baseCurrency.text == "Failed connection"

                }
            }
        }

        private fun updateUI(request: Request) {
            runOnUiThread{
                kotlin.run {
                    binding.lastupdated.text = request.code
                    binding.nzd.text = request.product.brands
                    binding.usd.text = request.product.product_name
                    binding.gbp.text = request.product.ingredients_text
                    dd=  request.product.ingredients_text.toString()
                    var d_list =dd.split(",").toTypedArray()
                    for(i in d_list){
                        gbp_list.add(i)
                    }
                    score(gbp_list)









                }


            }
        }
        private fun score(list: ArrayList<String>){
            fav = myDBHelper.getAllING()
            least = myDBHelper1.getAllING()


            var score = 10.0
            for (i in list){

                if (fav != null) {
                    for (j in fav){
                        if (j.uppercase() in i.uppercase()){
                            score = score + 0.5

                        }
                    }
                    if (least != null) {
                        for (k in least){
                            if (k.uppercase() in i.uppercase()){
                                score = score - 0.5


                            }
                        }
                    }


                }

            }

            findViewById<TextView>(R.id.baseCurrency).text=  score.toString()+"/20"




        }



    }

