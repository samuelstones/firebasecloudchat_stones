package com.example.firecloudchatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var datatext: EditText
    private lateinit var savebutton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        datatext = findViewById(R.id.edtnamesavedata)
        savebutton = findViewById(R.id.btnsavedata)

        //initialize
        var database = FirebaseDatabase.getInstance()
        var databaseRef = database.reference



        savebutton.setOnClickListener {


            var user_data =datatext.text.toString().trim()
            //Toast.makeText(this, "user_data", Toast.LENGTH_SHORT).show()

            databaseRef.setValue(user_data)





        }





    }
}