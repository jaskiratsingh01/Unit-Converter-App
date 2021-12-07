package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.math.BigDecimal

class speedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speed)


        supportActionBar?.hide();


        val inputT = findViewById<EditText>(R.id.input)
        val msT = findViewById<TextView>(R.id.ms)
        val khT = findViewById<TextView>(R.id.kh)

        val goBtn = findViewById<Button>(R.id.go_btn)





        val units = arrayOf("m/s","km/hr")

        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this, R.layout.my_spinner, units)
            spinner.adapter = adapter
        }

        var defaultPos = 0
        var invalidInput=true

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                defaultPos=position
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }


        goBtn.setOnClickListener{

            var inputString = inputT.text.toString()
            if(inputString == null || inputString.trim()=="")
            {
                Toast.makeText(applicationContext,"Enter a valid number",Toast.LENGTH_SHORT).show()
                invalidInput=true
            }
            var inputInt = inputString.toDoubleOrNull()

            if(inputInt==null || inputInt<0)
            {
                Toast.makeText(applicationContext,"Enter a valid number",Toast.LENGTH_SHORT).show()
                invalidInput=true
            }

            if (inputInt != null) {
                invalidInput=false
            }


            if(invalidInput==false)
            {
                if(defaultPos == 0)
                {
                    var msOut = inputInt
                    var khOut = inputInt?.times(3.6)

                    msT.setText(msOut.toString())
                    khT.setText(khOut.toString())

                }
                else if(defaultPos==1)
                {
                    var msOut = inputInt?.div(3.6)
                    var khOut = inputInt

                    msT.setText(msOut.toString())
                    khT.setText(khOut.toString())

                }
            }
            else
            {
                msT.setText("null")
                khT.setText("null")
            }

        }



    }
}
