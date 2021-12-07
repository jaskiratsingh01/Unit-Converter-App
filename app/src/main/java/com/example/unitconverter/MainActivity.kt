package com.example.unitconverter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.hide();

        val length = findViewById<LinearLayout>(R.id.lengthBtn)
        val temp = findViewById<LinearLayout>(R.id.tempBtn)
        val speed = findViewById<LinearLayout>(R.id.speedBtn)
        val mass = findViewById<LinearLayout>(R.id.massBtn)

        length.setOnClickListener{
            val intent = Intent(this, lengthActivity::class.java)
            startActivity(intent)
        }

        temp.setOnClickListener{
            val intent = Intent(this, tempActivity::class.java)
            startActivity(intent)
        }

        speed.setOnClickListener{
            val intent = Intent(this, speedActivity::class.java)
            startActivity(intent)
        }

        mass.setOnClickListener{
            val intent = Intent(this, massActivity::class.java)
            startActivity(intent)
        }

    }
}