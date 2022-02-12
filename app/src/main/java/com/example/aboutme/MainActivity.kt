package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Obinna Akuma")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //The code below binds the xml layout and the MainActivity.kt and give it functionality
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName
        //findViewById<Button>(R.id.done_button).setOnClickListener {
          //  addNickname(it)
        //}
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

    }

    /*
    So this code below, after creating the a private function of the view, we pass the different
    functionalities that will happen inside this nickname view group. Eg The edit text enables the
    text to be editable to put in the nickname, the visibility feature being set at Gone makes it possible for the
    nickname done button to be gone after being clicked.
     */
    private fun addNickname(view: View) {

        binding.apply {
            //nicknameText.text = binding.nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE

        }

        // This code below hides your keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)

    }
}