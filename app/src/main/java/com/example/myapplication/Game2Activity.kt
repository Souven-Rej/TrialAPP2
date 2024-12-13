package com.example.handcricketgame


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.google.android.material.button.MaterialButton
import kotlin.random.Random


class Game2Activity : AppCompatActivity() {


    private lateinit var textView1: TextView
    private lateinit var playerTextView: TextView
    private lateinit var cpuTextView: TextView
    private lateinit var totalScoreTextView: TextView
    private lateinit var nextButton: Button
    private lateinit var button1: MaterialButton
    private lateinit var button2: MaterialButton
    private lateinit var button3: MaterialButton
    private lateinit var button4: MaterialButton
    private lateinit var button5: MaterialButton
    private lateinit var button6: MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game2)


        textView1 = findViewById(R.id.textView1)
        playerTextView = findViewById(R.id.playerTextView)
        cpuTextView = findViewById(R.id.cpuTextView)
        totalScoreTextView = findViewById(R.id.totalScoreTextView)
        nextButton = findViewById(R.id.nextButton)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)


        val result = intent.getStringArrayExtra("totalScoreAndToss")
        val toss = result!![0].toString()


        textView1.text = toss
        val target = result[1].toInt()


        val arrayOfButtons = arrayOf(button1, button2, button3, button4, button5, button6)


        button1.setOnClickListener {
            updateScore(1, toss, arrayOfButtons, target)
        }
        button2.setOnClickListener {
            updateScore(2, toss, arrayOfButtons, target)
        }
        button3.setOnClickListener {
            updateScore(3, toss, arrayOfButtons, target)
        }
        button4.setOnClickListener {
            updateScore(4, toss, arrayOfButtons, target)
        }
        button5.setOnClickListener {
            updateScore(5, toss, arrayOfButtons, target)
        }
        button6.setOnClickListener {
            updateScore(6, toss, arrayOfButtons, target)
        }


        nextButton.setOnClickListener {
            val i = Intent(this, Result2Activity::class.java)
            val totalScoreAndToss = arrayOf(totalScoreTextView.text.toString(), (target - 1).toString(), toss)
            i.putExtra("totalScoreAndToss", totalScoreAndToss)
            startActivity(i)
        }
    }


    fun updateScore(currentPlayerValue: Int, toss: String, arrayOfButtons: Array<MaterialButton>, target: Int) {
        val currentCPUValue = Random.nextInt(1, 7)
        val toastMessage = if (toss == "Batting") "You are OUT!" else "CPU is OUT!"
        playerTextView.text = currentPlayerValue.toString()
        cpuTextView.text = currentCPUValue.toString()
        if (currentCPUValue == currentPlayerValue) {
            disableButtons(arrayOfButtons)
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
            nextButton.visibility = View.VISIBLE
        } else {
            totalScoreTextView.text = if (toss == "Batting")
                (totalScoreTextView.text.toString().toInt() + currentPlayerValue).toString()
            else (totalScoreTextView.text.toString().toInt() + currentCPUValue).toString()
        }


        if (totalScoreTextView.text.toString().toInt() >= target) {
            disableButtons(arrayOfButtons)
            Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show()
            nextButton.visibility = View.VISIBLE
        }
    }


    fun disableButtons(arrayOfButtons: Array<MaterialButton>) {
        for (i in arrayOfButtons.indices) {
            arrayOfButtons[i].isEnabled = false
        }
    }
}