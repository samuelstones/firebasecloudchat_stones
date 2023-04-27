package com.example.firecloudchatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var edtemail: EditText
    private lateinit var edtpassword: EditText
    private lateinit var loginbutton: Button
    private lateinit var regbutton: Button
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtemail = findViewById(R.id.edtemail)
        edtpassword = findViewById(R.id.Edtpassword)
        loginbutton = findViewById(R.id.Btnlogin)
        regbutton = findViewById(R.id.BtnRegister)

        auth = FirebaseAuth.getInstance()


        loginbutton.setOnClickListener {

            //
            var email = edtemail.text.toString().trim()
            var password = edtpassword.text.toString().trim()

            //validate input
            if (email.isEmpty()|| password.isEmpty()){
                Toast.makeText(this, "one of the fields is empty", Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()

                        var gotomain = Intent(this, MainActivity::class.java)
                        startActivity(gotomain)
                        finish()


                    }else{
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                    }
                }

            }

        }





        regbutton.setOnClickListener {

            var gotoreg = Intent(this, RegisterActivity::class.java)
            startActivity(gotoreg)
        }






    }
}