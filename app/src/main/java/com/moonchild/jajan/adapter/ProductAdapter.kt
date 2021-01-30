package com.moonchild.jajan.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.moonchild.jajan.R

internal class ProductAdapter(
    private val context: Context,
    private val numbersInWords: Array<String>,
    private val numberImage: Array<String>,
    private val category: String?
): BaseAdapter(){
    private var layoutInflater: LayoutInflater? = null
    private var imageView: ImageView? = null
    private lateinit var textView: TextView
    private lateinit var txtDescription : TextView
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
            convertView = layoutInflater!!.inflate(R.layout.list_product, null)
        }
        imageView = convertView?.findViewById(R.id.imgProduct)
        imageView?.let {
            Glide.with(it)
                .asBitmap()
                .load(numberImage[position])
                .apply(
                    RequestOptions()
                    .override(55, 55)
                    .fitCenter()
                    .format(DecodeFormat.PREFER_ARGB_8888)
                    .override(Target.SIZE_ORIGINAL))
                .into(imageView!!)
        }

        textView = convertView!!.findViewById(R.id.tvNamaProduk)
        txtDescription = convertView!!.findViewById(R.id.tvDeskripsi)
        textView.text = "$category ${numbersInWords[position]}"
        txtDescription.text = "Pakaian ini sangat nyaman dipakai, warna yang dipilih merupakan ..."
        return convertView
    }
}