package com.flitzso.ratefunctionkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.flitzso.ratefunctionkotlin.databinding.ActivityMainBinding  // Importe a classe de vinculação

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // Declare uma variável para a classe de vinculação

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Inicialize a classe de vinculação
        setContentView(binding.root)

        binding.showAlert.setOnClickListener {
            val inflater = layoutInflater.inflate(R.layout.custom_alert, null)
            val ratingBar = inflater.findViewById<RatingBar>(R.id.rating_bar)
            val comment = inflater.findViewById<EditText>(R.id.comment)

            val alert = AlertDialog.Builder(this)
            alert.setTitle("Enter Rate")
            alert.setView(inflater)
            alert.setCancelable(false)

            alert.setNegativeButton("Cancel") { _, _ ->
                Toast.makeText(this, "you clicked cancel", Toast.LENGTH_SHORT).show()
            }

            alert.setPositiveButton("post rate") { _, _ ->
                val userComment = comment.text.toString()
                val ratingValue = ratingBar.rating

                Toast.makeText(this, "Your rating is: $ratingValue, Your comment is: $userComment", Toast.LENGTH_SHORT).show()
            }

            val alertDialog = alert.create()
            alertDialog.show()
        }
    }
}
