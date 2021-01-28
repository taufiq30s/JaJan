package com.moonchild.jajan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.moonchild.jajan.ui.auth.LoginActivity
import com.moonchild.jajan.ui.auth.SignUpActivity

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
    }

    fun onClickBtnLg(view: View) {
        Intent(this, LoginActivity::class.java).apply {
            startActivity(this)
        }
    }
    fun onClickBtnRegist(view: View) {
        Intent(this, SignUpActivity::class.java).apply {
            startActivity(this)
        }
    }
}