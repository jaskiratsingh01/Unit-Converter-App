package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.math.BigDecimal

class lengthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_length)


        supportActionBar?.hide();


        val inputT = findViewById<EditText>(R.id.input)
        val milliT = findViewById<TextView>(R.id.milli)
        val centiT = findViewById<TextView>(R.id.centi)
        val meterT = findViewById<TextView>(R.id.meter)
        val kiloT = findViewById<TextView>(R.id.kilo)

        val goBtn = findViewById<Button>(R.id.go_btn)





        val units = arrayOf("Millimeter","Centimeter","Meter","Kilometer")

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
                if(inputInt>=0)
                    invalidInput=false
            }


            if(invalidInput==false)
            {
                if(defaultPos == 0)
                {
                    var millinum = inputInt
                    var centinum = inputInt?.toDouble()?.div(10)
                    var meternum = inputInt?.toDouble()?.div(1000)
                    var kilonum = inputInt?.toDouble()?.div(1000000)

                    milliT.setText(millinum.toString())
                    centiT.setText(centinum.toString())
                    meterT.setText(meternum.toString())
                    kiloT.setText(kilonum.toString())
                }
                else if(defaultPos==1)
                {
                    val millinum = inputInt?.toDouble()?.times(10)
                    val centinum = inputInt
                    val meternum = inputInt?.toDouble()?.div(100)
                    val kilonum = inputInt?.toDouble()?.div(100000)

                    milliT.setText(millinum.toString())
                    centiT.setText(centinum.toString())
                    meterT.setText(meternum.toString())
                    kiloT.setText(kilonum.toString())

                }
                else if(defaultPos==2)
                {
                    val millinum = inputInt?.toDouble()?.times(1000)
                    val centinum = inputInt?.toDouble()?.times(100)
                    val meternum = inputInt
                    val kilonum = inputInt?.toDouble()?.div(1000)

                    milliT.setText(millinum.toString())
                    centiT.setText(centinum.toString())
                    meterT.setText(meternum.toString())
                    kiloT.setText(kilonum.toString())

                }
                else if(defaultPos==3)
                {
                    val millinum = inputInt?.toDouble()?.times(1000000)
                    val centinum = inputInt?.toDouble()?.times(100000)
                    val meternum = inputInt?.toDouble()?.times(1000)
                    val kilonum = inputInt

                    milliT.setText(millinum.toString())
                    centiT.setText(centinum.toString())
                    meterT.setText(meternum.toString())
                    kiloT.setText(kilonum.toString())

                }
            }

        }



    }
}
