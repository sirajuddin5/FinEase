package com.example.finease

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.finease.databinding.ActivitySignupBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val db = Firebase.firestore


        binding.bttnSignup.setOnClickListener {
            val name = binding.tvName.text.toString()
            val email = binding.tvEmail.text.toString()
            val number = binding.tvNumber.text.toString()

            val user = hashMapOf(
                "name" to name ,
                "email" to email,
                "number" to number
            )

            validate()
            Log.d("TAG",name)
            Log.d("TAG",email)
            Log.d("TAG",number)

                db.collection("users")
                    .add(user)
                    .addOnSuccessListener { documentReference->
                        Log.d("STORING","Document added with id:${documentReference.id}")
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Some Error Ocurred", Toast.LENGTH_SHORT).show()
                    }

        }
    }
    private fun validate() {
        if (binding.tvName.length() == 0) {
            binding.tvName.setError("Please enter your name")
        } else if (binding.tvEmail.length() == 0) {
            binding.tvEmail.setError("please Enter your E-mail")
        } else if (binding.tvNumber.length() != 10) {
            binding.tvNumber.setError("Please Enter a Valid Number")
        }
    }

}