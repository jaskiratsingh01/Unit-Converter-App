package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.math.BigDecimal

class massActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mass)


        supportActionBar?.hide();


        val inputT = findViewById<EditText>(R.id.input)
        val milliT = findViewById<TextView>(R.id.milli)
        val gramT = findViewById<TextView>(R.id.gram)
        val kiloT = findViewById<TextView>(R.id.kilogram)
        val quinT = findViewById<TextView>(R.id.quintal)

        val goBtn = findViewById<Button>(R.id.go_btn)





        val units = arrayOf("milligram","gram","kilogram","quintal")

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
                    var milliOut = inputInt
                    var gramOut = inputInt?.div(1000)
                    var kiloOut = inputInt?.div(1000000)
                    var quinOut = inputInt?.div(100000000)

                    milliT.setText(milliOut.toString())
                    gramT.setText(gramOut.toString())
                    kiloT.setText(kiloOut.toString())
                    quinT.setText(quinOut.toString())

                }
                else if(defaultPos==1)
                {
                    var milliOut = inputInt?.times(1000)
                    var gramOut = inputInt
                    var kiloOut = inputInt?.div(1000)
                    var quinOut = inputInt?.div(100000)

                    milliT.setText(milliOut.toString())
                    gramT.setText(gramOut.toString())
                    kiloT.setText(kiloOut.toString())
                    quinT.setText(quinOut.toString())

                }
                else if(defaultPos == 2)
                {
                    var milliOut = inputInt?.times(1000000)
                    var gramOut = inputInt?.times(1000)
                    var kiloOut = inputInt
                    var quinOut = inputInt?.div(100)

                    milliT.setText(milliOut.toString())
                    gramT.setText(gramOut.toString())
                    kiloT.setText(kiloOut.toString())
                    quinT.setText(quinOut.toString())
                }
                else if(defaultPos==3)
                {
                    var milliOut = inputInt?.times(100000000)
                    var gramOut = inputInt?.times(1000000)
                    var kiloOut = inputInt?.times(100)
                    var quinOut = inputInt

                    milliT.setText(milliOut.toString())
                    gramT.setText(gramOut.toString())
                    kiloT.setText(kiloOut.toString())
                    quinT.setText(quinOut.toString())
                }
            }
            else
            {
                milliT.setText("null")
                gramT.setText("null")
                kiloT.setText("null")
                quinT.setText("null")
            }

        }



    }
}
