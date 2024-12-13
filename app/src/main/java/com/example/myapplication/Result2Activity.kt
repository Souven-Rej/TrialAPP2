package com.example.handcricketgame


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Result2Activity : AppCompatActivity() {


    private lateinit var yourScoreTextView: TextView
    private lateinit var cpuScoreTextView: TextView
    private lateinit var resultTextView: TextView
    private lateinit var menuButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result2)


        yourScoreTextView = findViewById(R.id.yourScore)
        cpuScoreTextView = findViewById(R.id.cpuScore)
        resultTextView = findViewById(R.id.resultView)
        menuButton = findViewById(R.id.menu)


        val result = intent.getStringArrayExtra("totalScoreAndToss")
        val toss = result!![2].toString()


        val yourScore = if (toss == "Bowling") result[1] else result[0]
        val cpuScore = if (toss == "Bowling") result[0] else result[1]


        yourScoreTextView.text = yourScore.toString()
        cpuScoreTextView.text = cpuScore.toString()


        val matchResult = when {
            yourScore.toInt() == cpuScore.toInt() -> "Wow! It's a DRAW!"
            yourScore.toInt() < cpuScore.toInt() -> "Uh-oh! You LOST!!"
            else -> "Hooray! You WON!"
        }


        resultTextView.text = matchResult


        menuButton.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}