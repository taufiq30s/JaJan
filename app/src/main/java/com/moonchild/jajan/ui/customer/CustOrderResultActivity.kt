package com.moonchild.jajan.ui.customer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.moonchild.jajan.R

class CustOrderResultActivity : AppCompatActivity() {
    private lateinit var lblProductResult : TextView
    private lateinit var lblTailorResult : TextView
    private lateinit var lblTotal : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cust_order_result)

        val orderData = intent.getStringArrayListExtra("EXTRA_ORDER_DATA_RES")
        val tailorName = intent.getStringExtra("EXTRA_TAILOR_NAME")
        val tailorPrice = intent.getStringExtra("EXTRA_TAILOR_PRICE")

        lblProductResult = findViewById(R.id.lblProductRes)
        lblTailorResult = findViewById(R.id.lblTailorRes)
        lblTotal = findViewById(R.id.lblTotal)

        setProductResult(orderData)
        setTailorResult(tailorName, tailorPrice)
        setTotal(tailorPrice, orderData[2].toInt())

        val btnFinish = findViewById<Button>(R.id.btnFinish)
        btnFinish.setOnClickListener {
            finish()
        }
    }

    fun onClickBtnFinish(view: View) {
        finish()
    }

    fun setProductResult(data: ArrayList<String>){
        lblProductResult.text = "Nama Produk : ${data[0]}\n" +
                                "Ukuran      : ${data[1]}\n" +
                                "Jumlah      : ${data[2]}\n" +
                                "Catatan     : ${data[3]}"
    }

    fun setTailorResult(name: String, price: String){
        lblTailorResult.text =  "Nama Tailor  : $name\n" +
                                "Biaya Jasa   : $price"
    }

    fun setTotal(price : String, num: Int){
        var priceFormated = price.removeRange(0, 4)
        priceFormated = priceFormated.replace(".", "")
        var priceInt = priceFormated.toInt()
        priceInt *= num
        lblTotal.text = "Total : Rp. ${thousandSeparator(priceInt, ".")}"
    }

    fun thousandSeparator(n: Int, ch: String?): String? {
        // Counting number of digits
        var n = n
        val l = Math.floor(Math.log10(n.toDouble())).toInt() + 1
        val str = StringBuffer("")
        var count = 0
        var r = 0

        // Checking if number of digits is greater than 3
        if (l > 3) {
            for (i in l - 1 downTo 0) {
                r = n % 10
                n = n / 10
                count++
                if (count % 3 == 0 && i != 0) {

                    // Parsing String value of Integer
                    str.append(r.toString())

                    // Appending the separator
                    str.append(ch)
                } else str.append(r.toString())
            }
            str.reverse()
        } else str.append(n.toString())
        return str.toString()
    }


}