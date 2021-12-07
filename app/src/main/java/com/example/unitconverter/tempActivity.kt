package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.math.BigDecimal

class tempActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp)


        supportActionBar?.hide();


        val inputT = findViewById<EditText>(R.id.input)
        val celT = findViewById<TextView>(R.id.cel)
        val fahrenT = findViewById<TextView>(R.id.fahren)
        val kelvinT = findViewById<TextView>(R.id.kelvin)

        val goBtn = findViewById<Button>(R.id.go_btn)





        val units = arrayOf("Celcius","Fahrenheit","Kelvin")

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

            if(inputInt==null || inputInt<273)
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
                    var celOut = inputInt
                    var fahrenOut = inputInt?.toDouble()?.times(1.8)?.plus(32)
                    var kelvinOut = inputInt?.toDouble()?.plus(273.15)

                    celT.setText(celOut.toString())
                    fahrenT.setText(fahrenOut.toString())
                    kelvinT.setText(kelvinOut.toString())
                }
                else if(defaultPos==1)
                {
                    if (inputInt != null) {
                        if(inputInt < 32) {
                            Toast.makeText(applicationContext,"Enter a valid number",Toast.LENGTH_SHORT).show()
                            celT.setText("null")
                            fahrenT.setText("null")
                            kelvinT.setText("null")

                        } else {
                            var celOut = inputInt?.toDouble()?.minus(32)?.times(1.8)
                            var fahrenOut = inputInt
                            var kelvinOut = celOut?.toDouble()?.plus(273.15)

                            celT.setText(celOut.toString())
                            fahrenT.setText(fahrenOut.toString())
                            kelvinT.setText(kelvinOut.toString())
                        }
                    }

                }
                else if(defaultPos==2)
                {
                    var kelvinOut = inputInt
                    var celOut = inputInt?.minus(273.15)
                    var fahrenOut = celOut?.toDouble()?.times(1.8)?.plus(32)

                    celT.setText(celOut.toString())
                    fahrenT.setText(fahrenOut.toString())
                    kelvinT.setText(kelvinOut.toString())

                }
            }
            else
            {
                celT.setText("null")
                fahrenT.setText("null")
                kelvinT.setText("null")
            }

        }



    }
}
