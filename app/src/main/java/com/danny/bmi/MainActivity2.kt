package com.danny.bmi

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.danny.bmi.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val TAG = MainActivity2::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    fun calculate(view: View) {
        var tital = ""
        var message = ""
        if (!binding.weight.text.toString().equals("") &&
            !binding.height.text.toString().equals("")
        ) {
            val weight = binding.weight.text.toString().toFloat()
            val height = binding.height.text.toString().toFloat()
            val bmi = Bmi(weight, height).toString()
            tital = "BMI"
            message = "Your BMI = ${bmi}"

        } else {
            tital = "Info"
            message = "Please enter weight and height"
        }
        AlertDialog.Builder(this)
            .setTitle(tital)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }

}