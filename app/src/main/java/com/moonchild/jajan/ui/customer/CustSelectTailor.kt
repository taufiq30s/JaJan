package com.moonchild.jajan.ui.customer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.moonchild.jajan.R
import com.moonchild.jajan.adapter.TailorAdapter
import kotlin.random.Random

class CustSelectTailor : AppCompatActivity() {
    lateinit var gridv : GridView

    // List Category
    private val tailorList = arrayOf(
        "Usada Tailor",
        "Delion Tailor",
        "Vesera Tailor",
        "Hirayuki aoi Tailor",
        "Iofi Tailor",
        "Minyak Sayur Tailor",
        "Kepin K Tailor",
        "Evelyn Tailor",
        "Feliz Tailor",
        "VSI Tailor"
    )
    private val taylorIcon = R.drawable.ic_account
    private lateinit var sizeProduct : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cust_select_tailor)

        val orderData = intent.getStringArrayListExtra("EXTRA_ORDER_DATA")
        sizeProduct = orderData[1]
        gridv = findViewById(R.id.gridViewTaylor)
        val prices = generatePrice(sizeProduct, tailorList.size)
        val mainAdapter = TailorAdapter(this, tailorList, taylorIcon, sizeProduct, prices)
        gridv.adapter = mainAdapter
        gridv.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Log.d("Tester X", mainAdapter.getItem(position).toString())
            Intent(this, CustOrderResultActivity::class.java).apply{
                this.putExtra("EXTRA_ORDER_DATA_RES", orderData)
                this.putExtra("EXTRA_TAILOR_NAME", tailorList[position])
                this.putExtra("EXTRA_TAILOR_PRICE", "Rp. ${thousandSeparator(prices[position], ".")}")
                startActivity(this)
                finish()
            }
        }
    }

    fun generatePrice(size: String, numOfTailors: Int): ArrayList<Int>{
        var price = 0
        val prices = arrayListOf<Int>()
        for(i in 0..numOfTailors-1){
            when(size){
                "S" -> price = rand(50000, 150000)
                "M" -> price = rand(100000, 200000)
                "L" -> price = rand(150000, 250000)
                "XL" -> price = rand(200000, 300000)
            }
            prices.add(price)
        }
        return prices
    }

    fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        val rand = Random(System.nanoTime())
        return (start..end).random(rand)
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