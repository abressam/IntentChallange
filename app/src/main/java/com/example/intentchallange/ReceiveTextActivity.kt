package com.example.intentchallange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ReceiveTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_text)

        if (intent?.action == Intent.ACTION_SEND && intent?.type == "text/plain") {
            val text = intent?.getStringExtra(Intent.EXTRA_TEXT)
            val textView = findViewById<TextView>(R.id.textView)
            textView.text = text
        }

        val goBackButton = findViewById<Button>(R.id.button_go_back)
        goBackButton.setOnClickListener {
            val changeActivity = Intent(this, SendTextActivity::class.java)
            startActivity(changeActivity)
        }
    }
}