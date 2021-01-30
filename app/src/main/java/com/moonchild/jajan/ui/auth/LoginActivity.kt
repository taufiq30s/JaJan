package com.moonchild.jajan.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.moonchild.jajan.R
import com.moonchild.jajan.ui.customer.CustHomeActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            Log.d("Tester", "Dulu kau bersumpah janji didepan saksi")
            onClickBtnLogin()
        }
    }

    fun onClickBtnLogin() {
        Intent(this, CustHomeActivity::class.java).apply{
            startActivity(this)
        }
    }
}