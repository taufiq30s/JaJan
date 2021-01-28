package com.moonchild.jajan.ui.auth

import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.moonchild.jajan.R
import java.text.SimpleDateFormat
import java.util.*


class SignUpTailorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_tailor)
        val txtBuka = findViewById<EditText>(R.id.txtJamBuka)
        val txtTutup = findViewById<EditText>(R.id.txtJamTutup)

        txtBuka.setOnClickListener {
            Log.d("Tester", "Kalbu Hatimu")
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                txtBuka.setText(SimpleDateFormat("HH:mm").format(cal.time))
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }

        txtTutup.setOnClickListener {
            Log.d("Tester", "Perjalanan ini terasa sangat menyedihkan")
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                txtTutup.setText(SimpleDateFormat("HH:mm").format(cal.time))
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }
    }

    fun onClickBtnRegisterToko(view: View) {
        // TODO : Home Tailor
    }
}