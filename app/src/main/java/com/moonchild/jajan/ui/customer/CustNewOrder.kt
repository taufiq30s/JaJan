package com.moonchild.jajan.ui.customer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.moonchild.jajan.R

class CustNewOrder : AppCompatActivity() {
    private lateinit var rgSize : RadioGroup
    private lateinit var size : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cust_new_order)

        val imgUrl = intent.getStringExtra("EXTRA_IMAGE_URL")
        val productName = intent.getStringExtra("EXTRA_PRODUCT_NAME")
        val imgProduct = findViewById<ImageView>(R.id.imgOrderProduct)
        val lblProductName = findViewById<TextView>(R.id.lblProductName)
        rgSize = findViewById(R.id.rgSize)

        imgProduct?.let {
            Glide.with(it)
                .asBitmap()
                .load(imgUrl)
                .apply(
                    RequestOptions()
                        .override(55, 55)
                        .fitCenter()
                        .format(DecodeFormat.PREFER_ARGB_8888)
                        .override(Target.SIZE_ORIGINAL))
                .into(imgProduct!!)
        }

        lblProductName.text = productName

        rgSize.setOnCheckedChangeListener { group, checkedId ->
            Log.d("Tester", "Delion :hm2:")
            when (checkedId) {
                R.id.rbS -> {
                    size = "S"
                }
                R.id.rbM -> {
                    size = "M"
                }
                R.id.rbL -> {
                    size = "L"
                }
                R.id.rbXL -> {
                    size = "XL"
                }
            }
        }
    }

    fun onClickBtnFindTaylor(view: View) {
        val arrayOrderData = arrayListOf<String>(findViewById<TextView>(R.id.lblProductName).text.toString()
                                ,size, findViewById<EditText>(R.id.txtJumlahOrder).text.toString()
                                , findViewById<EditText>(R.id.txtCatatanOrder).text.toString())
//        Log.d("Tester 1", Arrays.toString(arrayOrderData))
        Intent(this, CustSelectTailor::class.java).apply{
            this.putExtra("EXTRA_ORDER_DATA", arrayOrderData)
            startActivity(this)
            finish()
        }
    }
}