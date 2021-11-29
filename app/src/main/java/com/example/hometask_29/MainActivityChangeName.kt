package com.example.hometask_29


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_changename.*
import android.view.View

import android.widget.ArrayAdapter
import android.widget.AdapterView


class MainActivityChangeName: AppCompatActivity() {

    var range = arrayOf(">18", "18-20", "20-30", "30-35", "35-40", "40-45", "45-50", "50-60", "60+")


    //var arr: IntArray = IntArray(5) { it + 1 }
    //var list: MutableList<Int> = arr.toCollection(ArrayList())

    //var range //= ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_changename)


        // adapter
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, range)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spAge.setAdapter(adapter)


        val itemSelectedListener: AdapterView.OnItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {

                    // Get picked element
                    val item = parent.getItemAtPosition(position) as String
                    tvSpinner.setText(item)

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        spAge.setOnItemSelectedListener(itemSelectedListener)



        makechanges()


    }


    fun makechanges() {


        btdochanges.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            val toastErrorMassage = Toast.makeText(
                applicationContext,
                "Please, fulfill the data",
                Toast.LENGTH_LONG
            ) as Toast

            if
                    ((edChangeName.getText().toString() != null) || (edChangeSurname.getText()
                    .toString() != null)
            ) {
                intent.putExtra("FirstName", edChangeName.getText().toString())
                intent.putExtra("SurName", edChangeSurname.getText().toString())
                intent.putExtra("Age", tvSpinner.getText().toString())
                startActivity(intent)
            } else {
                toastErrorMassage.show()
            }
        }
    }

}