package com.example.firecloudchatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var edtcarmake: EditText
    private lateinit var edtcarmodel: EditText
    private lateinit var edtcarprice: EditText

    private lateinit var carphoto: Button
    private lateinit var cardata: Button
    private lateinit var viewcars: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        edtcarmake = findViewById(R.id.editcarmake)
        edtcarmodel = findViewById(R.id.editcarmodel)
        edtcarprice = findViewById(R.id.editcarprice)

        carphoto = findViewById(R.id.btncarphoto)
        cardata = findViewById(R.id.btncardata)
        viewcars = findViewById(R.id.btnviewuploadcars)




        //initialize
        var database = FirebaseDatabase.getInstance()
        var databaseref = database.getReference("cars")


        carphoto.setOnClickListener {

        }




        cardata.setOnClickListener {

            var make = edtcarmake.text.toString().trim()
            var model = edtcarmodel.text.toString().trim()
            var price = edtcarprice.text.toString().trim()

            //validate inputs

            if (make.isEmpty() || model.isEmpty() || price.isEmpty()) {
                Toast.makeText(this, "one of the fields is empty :(", Toast.LENGTH_SHORT).show()
            } else {
                //saving info to firebase db
                var usercar = Car(make,model,price)

                var ref = FirebaseDatabase.getInstance().getReference().child("cars")

                ref.setValue(usercar).addOnCompleteListener{

                    if (it.isSuccessful){
                        Toast.makeText(this,"Car Data Uploaded Successfully",
                            Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this,"Failed tO Save Car Info",
                            Toast.LENGTH_LONG).show()
                    }

                }




            }












        }

        viewcars.setOnClickListener {

        }





    }
}