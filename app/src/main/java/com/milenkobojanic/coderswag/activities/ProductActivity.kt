package com.milenkobojanic.coderswag.activities

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.milenkobojanic.coderswag.R
import com.milenkobojanic.coderswag.adapters.ProductsAdapter
import com.milenkobojanic.coderswag.services.DataService
import com.milenkobojanic.coderswag.utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType))

        var spanCount = 2
        val orientation = resources.configuration.orientation
        val screenSize = resources.configuration.screenWidthDp

        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        if (screenSize > 720) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        productListView.layoutManager = layoutManager
        productListView.adapter = adapter
    }
}
