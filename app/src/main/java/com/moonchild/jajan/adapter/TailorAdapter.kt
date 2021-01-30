package com.moonchild.jajan.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.moonchild.jajan.R
import kotlin.random.Random

internal class TailorAdapter(
        private val context: Context,
        private val numbersInWords: Array<String>,
        private val numberImage: Int,
        private val size: String,
        private val prices: ArrayList<Int>
):
    BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var priceView: TextView


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

    override fun getCount(): Int {
        return numbersInWords.size
    }
    override fun getItem(position: Int): Any? {
        return null
    }
    override fun getItemId(position: Int): Long {
        return 0
    }
    override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup
    ): View? {
        var convertView = convertView
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.list_tailor, null)
        }
        imageView = convertView!!.findViewById(R.id.imgTaylor)
        textView = convertView.findViewById(R.id.lblTaylorName)
        priceView = convertView.findViewById(R.id.lblHarga)
        imageView.setImageResource(numberImage)
        textView.text = numbersInWords[position]
        priceView.text = "Rp. ${thousandSeparator(prices[position], ".")}"
        Log.d("Tester Adapter pre1", prices[position].toString())
        Log.d("Tester Adapter pre2", priceView.text.toString())
        return convertView
    }
}