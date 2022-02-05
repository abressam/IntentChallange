package com.example.intentchallange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SendTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shareButton = findViewById<Button>(R.id.share_button)
        shareButton.setOnClickListener {
            shareMessage()
        }
    }

    private fun shareMessage() {

        val message = findViewById<EditText>(R.id.myMessage).text.toString()
        val dear = findViewById<EditText>(R.id.dear_id).text.toString()
        val from = findViewById<EditText>(R.id.from_id).text.toString()

        val birthdayCard = "Dear, $dear\n\n $message\n\n From $from."

        val shareIntent = Intent().apply {
            this.action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, birthdayCard)
            this.type = "text/plain"
        }
        startActivity(shareIntent)
    }
}