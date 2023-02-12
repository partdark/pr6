package com.example.pr6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity1)
        val buttonNext : Button = findViewById(R.id.next1)
        buttonNext.setOnClickListener {  val intent = Intent (this, MainActivity2::class.java) }

    }
}