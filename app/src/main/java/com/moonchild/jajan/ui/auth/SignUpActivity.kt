package com.moonchild.jajan.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import com.moonchild.jajan.R
import com.moonchild.jajan.ui.customer.CustHomeActivity

class SignUpActivity : AppCompatActivity() {
    // Intialize rb variables
    private lateinit var rbCustomer : RadioButton
    private lateinit var rgRole : RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        rbCustomer = findViewById(R.id.rbCustomer)
        rgRole = findViewById(R.id.rgRole)
        val btnRegistFirst = findViewById<Button>(R.id.btnRegister)

        rgRole.setOnCheckedChangeListener { group, checkedId ->
            Log.d("Tester", "Delion :hm:")
            if(rbCustomer.isChecked && checkedId == R.id.rbCustomer){
                btnRegistFirst.setText("Register")
            }
            else if(checkedId == R.id.rbPenjahit){
                btnRegistFirst.setText("Next")
            }
        }
    }

    fun onClickBtnRegister(view: View) {
        if(rbCustomer.isChecked){
            Intent(this, CustHomeActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }
        else{
            Intent(this, SignUpTailorActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}