package com.kevinmuchene.amazonecommerceapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ShoppingCategory : AppCompatActivity() {

    private lateinit var homeAndKitchenImg: ImageView;
    private lateinit var beautyAndPersonalCareImg: ImageView
    private lateinit var petSuppliesImg: ImageView
    private lateinit var toysAndGamesImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

         homeAndKitchenImg = findViewById(R.id.homeAndKitchenImg)
         beautyAndPersonalCareImg = findViewById(R.id.beautyAndPersonalCareImg)
         petSuppliesImg = findViewById(R.id.petSuppliesImg)
         toysAndGamesImg = findViewById(R.id.toysAndGamesImg)

        homeAndKitchenImg.setOnClickListener {
            showToast("Home and Kitchen")
        }

        beautyAndPersonalCareImg.setOnClickListener {
            showToast("Beauty and Personal Care")
        }

        petSuppliesImg.setOnClickListener {
            showToast("Pet Supplies")
        }

        toysAndGamesImg.setOnClickListener {
            showToast("Toys and Games")
        }
    }

    private fun showToast(category: String) {
        Toast.makeText(this, "Selected category: $category", Toast.LENGTH_SHORT).show()
    }
}
