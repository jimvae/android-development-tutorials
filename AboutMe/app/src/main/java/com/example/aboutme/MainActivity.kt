package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Jim Vincent Andes Engay")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main) //show the content of this activity
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickname(it)
//        }

        //data binding
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
//            nicknameText.text = binding.nicknameEdit.text
            invalidateAll() //to create them with the actual data
            nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        //Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}