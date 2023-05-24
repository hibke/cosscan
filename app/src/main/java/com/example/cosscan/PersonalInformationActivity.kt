package com.example.cosscan

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class PersonalInformationActivity : AppCompatActivity() {
    private lateinit var checkBox: CheckBox
    private lateinit var checkBox1: CheckBox
    private lateinit var editText: EditText
    private lateinit var btnsub: Button
    private lateinit var btndis: Button
    private lateinit var btnsuba: Button
    private lateinit var btndisa: Button


    private lateinit var myDBHelper: MyDBHelper
    private lateinit var myDBHelper1: MyDBHelper1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_information)
        initView()
        myDBHelper = MyDBHelper(this)
        myDBHelper1 = MyDBHelper1(this)

        btnsub.setOnClickListener{ addIng() }

        btndis.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, DisplayPersonalInformation::class.java)
            startActivity(intent)
        })
        btnsuba.setOnClickListener{ addInga() }

        btndisa.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, DisplayPersonalInformation::class.java)
            startActivity(intent)
        })





    }



    private fun addIng() {

        myDBHelper.drop()
        for (i in 1..64){
            var viewId = resources.getIdentifier("checkBox$i", "id", packageName)
            if(findViewById<CheckBox>(viewId).isChecked){
               myDBHelper.insertIng(findViewById<CheckBox>(viewId).getText().toString())

            }
        }
            Toast.makeText(this, "Ingredients Added", Toast.LENGTH_LONG).show()



    }

    private fun addInga() {

        myDBHelper1.drop()
        for (i in 1..64){
            var viewId = resources.getIdentifier("checkBoxa$i", "id", packageName)
            if(findViewById<CheckBox>(viewId).isChecked){
                var status= myDBHelper1.insertIng(findViewById<CheckBox>(viewId).getText().toString())


            }

        }
        Toast.makeText(this, "Ingredients Added", Toast.LENGTH_LONG).show()




    }

    private fun addIng1() {
        val ing = editText.text.toString()
        if (checkBox.isChecked()){

            val status = myDBHelper.insertIng(checkBox.getText().toString())

        }
        if(ing.isEmpty()){
            Toast.makeText(this, "Please enter required field", Toast.LENGTH_LONG).show()
        } else{
            val status = myDBHelper.insertIng(ing)
            if (status > -1) {
                Toast.makeText(this, "Ingredients Added", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Ingredients not Added", Toast.LENGTH_LONG).show()

            }

        }
    }

    private fun initView() {

        btnsub= findViewById(R.id.button4)
        btndis= findViewById(R.id.button5)
        btnsuba=findViewById(R.id.button6)
        btndisa=findViewById(R.id.button7)












    }
}
