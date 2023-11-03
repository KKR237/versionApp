package com.keyur.versionapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible

class LoginSC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_sc)

        var logoImg = findViewById<ImageView>(R.id.logoImageView)
        var welcomTxt = findViewById<TextView>(R.id.welcomText)
        welcomTxt.isVisible = false
        var emailText = findViewById<TextView>(R.id.emailEditText)
        var passwordText = findViewById<TextView>(R.id.passwordEditText)
        var loginBtn = findViewById<Button>(R.id.loginButton)

        loginBtn.setOnClickListener{
            welcomTxt.isVisible = true
            welcomTxt.text = "Hello ${emailText.text}"

            val progress: ProgressDialog
            progress = ProgressDialog(this)
            progress.setTitle("Please Wait!!")
            progress.setMessage("Wait!!")
            progress.setCancelable(true)
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            progress.show()

            Handler(Looper.getMainLooper()).postDelayed({
                var intent = Intent(this,HomeSC::class.java)
                intent.putExtra("email",emailText.text.toString())
                startActivity(intent)
                finish()
            }, 3000)

        }
    }
}