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

        val shareButton: Button = findViewById(R.id.share_button)
        shareButton.setOnClickListener {
            shareMessage()
        }
    }

    private fun shareMessage() {

        val editTextMessage: EditText = findViewById(R.id.myMessage)
        val editTextDear: EditText = findViewById(R.id.dear_id)
        val editTextFrom: EditText = findViewById(R.id.from_id)

        val dear = editTextDear.text.toString()
        val from = editTextFrom.text.toString()
        val message = editTextMessage.text.toString()

        val shareIntent = Intent().apply {
            this.action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Dear, $dear")
            putExtra(Intent.EXTRA_TEXT, message)
            putExtra(Intent.EXTRA_TEXT, from)
            this.type = "text/plain"
        }
        startActivity(shareIntent)
    }
}