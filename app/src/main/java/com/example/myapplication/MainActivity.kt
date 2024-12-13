package com.example.handcricketgame


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R


class MainActivity : AppCompatActivity() {


    private lateinit var batButton: Button
    private lateinit var bowlButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        batButton = findViewById(R.id.batButton)
        bowlButton = findViewById(R.id.bowlButton)


        batButton.setOnClickListener {
            callIntent("Batting")
        }


        bowlButton.setOnClickListener {
            callIntent("Bowling")
        }


    }


    fun callIntent(toss: String) {
        val i = Intent(this , Game1Activity::class.java)
        i.putExtra("toss" , toss)
        startActivity(i)
    }
}