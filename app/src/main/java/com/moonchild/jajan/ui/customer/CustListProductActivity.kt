package com.moonchild.jajan.ui.customer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ListView
import com.moonchild.jajan.R
import com.moonchild.jajan.adapter.ProductAdapter

class CustListProductActivity : AppCompatActivity() {
    lateinit var listProduct : ListView

    // List Product
    private val productList = arrayOf("Biru", "Merah", "Kuning", "Hijau", "Abu-Abu", "Ungu")
    private val productimg = arrayOf("https://source.unsplash.com/400x400/?dress,shirt,jeans,clothes,jacket?1234567890"
                                , "https://source.unsplash.com/400x400/?dress,shirt,jeans,clothes,jacket?0123456789"
                                , "https://source.unsplash.com/400x400/?dress,shirt,jeans,clothes,jacket?012345678"
                                , "https://source.unsplash.com/400x400/?dress,shirt,jeans,clothes,jacket?0123456781"
                                , "https://source.unsplash.com/400x400/?dress,shirt,jeans,clothes,jacket?01234567528"
                                , "https://source.unsplash.com/400x400/?dress,shirt,jeans,clothes,jacket?0123456178")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cust_list_product)

        // Get Category
        val cat = intent.getStringExtra("CATEGORY")
        this.title = "Produk ${cat}"

        listProduct = findViewById(R.id.lvProduct)
        val productAdapter = ProductAdapter(this, productList, productimg, cat)
        listProduct.adapter = productAdapter
        listProduct.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val img = productimg[position]
            val productName = "$cat ${productList[position]}"
            Log.d("Tester A", productName)
            Intent(this, CustNewOrder::class.java).apply {
                this.putExtra("EXTRA_IMAGE_URL", img)
                this.putExtra("EXTRA_PRODUCT_NAME", productName)
                startActivity(this)
                finish()
            }
        }
    }
}