package com.example.firecloudchatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var edtfullname: EditText
    private lateinit var edtemailreg: EditText
    private lateinit var editpasswordreg: EditText
    private lateinit var createbutton: Button


    //initialize firebase
    private lateinit var Auth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edtfullname = findViewById(R.id.Edtnamereg)
        edtemailreg = findViewById(R.id.Edtemailreg)
        editpasswordreg = findViewById(R.id.Edtpasswordreg)
        createbutton = findViewById(R.id.Btncreatereg)

        //initialize firebase again
        Auth = FirebaseAuth.getInstance()

        createbutton.setOnClickListener {

            var name = edtfullname.text.toString().trim()
            var email = edtemailreg.text.toString().trim()
            var password = editpasswordreg.text.toString().trim()


            //validate inputs

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "one of the fields is empty :(", Toast.LENGTH_SHORT).show()
            } else {
                //create a user in firebase
                Auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                    if (it.isSuccessful){
                        Toast.makeText(this, "user created successfuly", Toast.LENGTH_SHORT).show()

                        var gotologin = Intent(this,LoginActivity::class.java)
                        startActivity(gotologin)
                        finish()

                    }else{
                        Toast.makeText(this, "Failed to create Account", Toast.LENGTH_SHORT).show()
                    }

                }

            }

        }



    }
}