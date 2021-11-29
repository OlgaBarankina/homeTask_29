package com.example.hometask_29

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_changename.*

class MainActivity : AppCompatActivity() {

    val Gallery = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


// add into manifest file additional condition

        val toast = Toast.makeText(applicationContext, "Please, enter Login and Password", Toast.LENGTH_LONG) as Toast


        bvChangeAvatar.setOnClickListener {
            val intent = Intent()

            intent.setType("image/*")               //take all images
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult( Intent.createChooser(intent,"Select new Avatar"),Gallery)

        }


        val intent = intent

        val FirstName = intent.getStringExtra("FirstName")
        tvUserName.setText(FirstName)


        val SurName = intent.getStringExtra("SurName")
        tvUserSurName.setText(SurName)

        val Age = intent.getStringExtra("Age")
        tvUserAge.setText(Age)


        toast.show()
        goToMainPage()
        goToChangeData()


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Gallery && resultCode == RESULT_OK) {
            val imageUri = data?.data
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver,imageUri)
            ivMainPhoto.setImageBitmap(bitmap)
        }
        else {
            (requestCode == Gallery && resultCode == RESULT_OK)
        }
    }


    fun goToMainPage() {
        clLogin.setVisibility(View.VISIBLE)

        val toastError = Toast.makeText(applicationContext, "Wrong Password! Try again", Toast.LENGTH_LONG) as Toast

        btLogin.setOnClickListener {
            if ((edLogin.getText().toString().equals("olgab")) && (edPassword.getText().toString()
                    .toInt().equals(12345))
            ) {
                clLogin.setVisibility(View.INVISIBLE)
            } else {
                toastError.show()
            }

        }
    }



    fun goToChangeData() {
        bvChangeNameSurname.setOnClickListener {
            val intent = Intent(this, com.example.hometask_29.MainActivityChangeName::class.java)
            startActivity(intent)
        }
    }



}



