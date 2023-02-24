package com.example.pr6

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity1 : AppCompatActivity() {
    var colors = arrayListOf(Color.GREEN,Color.WHITE,Color.RED, Color.CYAN)
    var sheetNumber = 0
    var textSize = 18F

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity1)
              val text : EditText = findViewById(R.id.text)
        text.textSize = textSize
        sheetNumber = getIntent().getIntExtra("sheetNumber",0)
        val buttonNext : Button = findViewById(R.id.next1)
                buttonNext.setOnClickListener {
            if (sheetNumber < colors.size -1)
            {
                val intent = Intent (this, this::class.java)
                intent.putExtra("sheetNumber", sheetNumber + 1)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "its all",Toast.LENGTH_SHORT).show()
            }
        }

    }



    override fun onPause() {
        val text : EditText = findViewById(R.id.text)
        val newSize : EditText = findViewById(R.id.new_size)
        super.onPause()
        val pref = getPreferences(MODE_PRIVATE).edit()
        val prefs = getPreferences(MODE_PRIVATE).edit()
        prefs.putString("noteSize" + sheetNumber, newSize.text.toString())
        pref.putString("note" + sheetNumber, text.editableText.toString())
        pref.apply()
        prefs.apply()
    }

    override fun onResume() {
        val text : EditText = findViewById(R.id.text)
        val newSize : EditText = findViewById(R.id.new_size)
        super.onResume()
        val sheet : ConstraintLayout = findViewById(R.id.sheet1)
       sheet.setBackgroundColor(colors[sheetNumber])
        text.textSize =textSize
        val saveState = getPreferences(Context.MODE_PRIVATE).getString("note" + sheetNumber, null)
        if (saveState !=null) {
            text.setText(saveState)
        }
        val savState = getPreferences(Context.MODE_PRIVATE).getString("noteSize" + sheetNumber, null)
        if (savState !=null) {
            newSize.setText(savState)
        }
        if (newSize.length() > 0)
        {
            text.textSize =(newSize.text.toString()).toFloat()
        }

    }

 fun newSize (view : View) {

val size : EditText = findViewById(R.id.new_size)
         val text : EditText = findViewById(R.id.text)
     textSize = (size.text.toString()).toFloat()
     text.textSize = textSize
 }




}