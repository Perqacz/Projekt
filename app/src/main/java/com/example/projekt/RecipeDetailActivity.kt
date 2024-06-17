package com.example.projekt

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.projekt.Model.Recipe


class RecipeDetailActivity : AppCompatActivity() {

    private lateinit var textRecipeName: TextView
    private lateinit var textCookingTime: TextView
    private lateinit var textInstructions: TextView
    private lateinit var containerIngredients: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        textRecipeName = findViewById(R.id.text_recipe_name)
        textCookingTime = findViewById(R.id.text_cooking_time)
        textInstructions = findViewById(R.id.text_instructions)
        containerIngredients = findViewById(R.id.container_ingredients)

        val recipe = intent.getSerializableExtra("recipe") as Recipe

        textRecipeName.text = recipe.name
        textCookingTime.text = "Cooking Time: ${recipe.cookingTime} minutes"
        textInstructions.text = recipe.instructions

        // Populate ingredients
        recipe.ingredients.forEach { ingredient ->
            val textView = TextView(this)
            textView.text = "${ingredient.name}: ${ingredient.quantity} ${ingredient.unit}"
            containerIngredients.addView(textView)
        }
    }
}
