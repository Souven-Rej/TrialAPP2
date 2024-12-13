package com.example.handcricketgame


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Result1Activity : AppCompatActivity() {


    private lateinit var totalScoreTextView: TextView
    private lateinit var targetTextView: TextView
    private lateinit var messageTextView: TextView
    private lateinit var nextButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result1)


        totalScoreTextView = findViewById(R.id.totalScore)
        targetTextView = findViewById(R.id.target)
        messageTextView = findViewById(R.id.message)
        nextButton = findViewById(R.id.next)




        val intentResult = intent.getStringArrayExtra("totalScoreAndToss")
        val totalScores = intentResult!![0]
        totalScoreTextView.text = totalScores
        targetTextView.text = (totalScores.toInt() + 1).toString()


        val toss = intentResult[1]


        messageTextView.text = if (toss == "Batting") "You need to defend $totalScores runs"
        else "You need to chase ${targetTextView.text} runs"


        nextButton.setOnClickListener {
            val i = Intent(this, Game2Activity::class.java)
            i.putExtra("totalScoreAndToss", arrayOf(if (toss == "Batting") "Bowling" else "Batting", targetTextView.text.toString()))
            startActivity(i)
        }
    }
}