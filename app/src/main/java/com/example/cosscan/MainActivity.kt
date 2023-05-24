package com.example.cosscan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        val NavBtn = findViewById<Button>(R.id.button1)
        NavBtn.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, ScanActivity::class.java)
            startActivity(intent)
        })
        val NavBtn1 = findViewById<Button>(R.id.button2)
        NavBtn1.setOnClickListener(View.OnClickListener {

            val intent1 = Intent(this, PersonalInformationActivity::class.java)
            startActivity(intent1)
        })
        val NavBtn2 = findViewById<Button>(R.id.butaton2)
        NavBtn2.setOnClickListener(View.OnClickListener {

            val intent3 = Intent(this, DisplayPersonalInformation::class.java)
            startActivity(intent3)
        })
    }
}