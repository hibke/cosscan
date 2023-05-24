package com.example.cosscan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DisplayPersonalInformation : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var btnsub: Button
    private lateinit var btndis: Button

    private lateinit var recyclerView1: RecyclerView
    private var adapter1: IngaAdapter? = null

    private lateinit var recyclerView:RecyclerView
    private var adapter: IngAdapter? = null
    private lateinit var myDBHelper1: MyDBHelper1
    private lateinit var myDBHelper: MyDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_personal_information)
        myDBHelper1 = MyDBHelper1(this)
        myDBHelper = MyDBHelper(this)
        initView()
        initRecyclerView()
        initRecyclerView1()

        getIngredients()
        getIngredients1()





    }

    private fun getIngredients() {
        val list = myDBHelper.getAllING()
        adapter?.addItems(list)



    }
    private fun getIngredients1() {
        val list = myDBHelper1.getAllING()
        adapter1?.addItems(list)


    }
    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = IngAdapter()
        recyclerView.adapter = adapter



    }
    private fun initRecyclerView1() {
        recyclerView1.layoutManager = LinearLayoutManager(this)
        adapter1 = IngaAdapter()
        recyclerView1.adapter = adapter1



    }


    private fun initView() {
       recyclerView = findViewById(R.id.recyclerView)
        recyclerView1 = findViewById(R.id.recyclerView1)


    }


}
