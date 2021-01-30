package com.moonchild.jajan.ui.customer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.moonchild.jajan.R
import com.moonchild.jajan.adapter.CategoryAdapter

class CustHomeActivity : AppCompatActivity() {
    lateinit var gridv : GridView

    // List Category
    private val categoryList = arrayOf("Celana", "Dress", "Jas", "Jeans", "Kaos", "Kemeja")
    private val categoryIcon = intArrayOf(R.drawable.ic_trousers, R.drawable.ic_dress,
                                R.drawable.ic_suit, R.drawable.ic_jeans, R.drawable.ic_kaos,
                                R.drawable.ic_kemeja)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cust_home)
        gridv = findViewById(R.id.homeGridMenu)
        val mainAdapter = CategoryAdapter(this, categoryList, categoryIcon)
        gridv.adapter = mainAdapter
        gridv.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Intent(this, CustListProductActivity::class.java).apply{
                this.putExtra("CATEGORY", categoryList[position])
                startActivity(this)
            }
//            Toast.makeText(applicationContext, "You CLicked " + categoryList[+position] + " "
//                    + (position).toString(),
//                    Toast.LENGTH_SHORT).show()
        }
    }
}