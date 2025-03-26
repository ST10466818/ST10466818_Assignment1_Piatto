package za.co.varsitycollege.st10466818.piatto

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Edit text for Time of day
        val editTextTOD = findViewById<EditText>(R.id.editTextTOD)
        //val appName = findViewById<TextView>(R.id.appName)
        val buttonPiattoPick = findViewById<Button>(R.id.buttonPiattoPick)
        val resetHomebutton = findViewById<Button>(R.id.restHomeButton)
        val textViewPiattoPick = findViewById<TextView>(R.id.textViewYourPiattoPick)

        //The button for Meal suggestions
        buttonPiattoPick.setOnClickListener {
            Toast.makeText(this@MainActivity, "Your Pick", Toast.LENGTH_SHORT).show()

            // When statement with all options
            when (editTextTOD.text.toString().lowercase()) {
                //User inputs Time of day
                "morning" -> {
                    //Breakfast options should appear
                    textViewPiattoPick.text = "Breakfast:" +
                            " Breakfast Burrito ; Shakshuka ; Stove Top Oats"
                }
                "mid morning" -> {
                    //Morning Snack options should appear
                    textViewPiattoPick.text = "Snack: " +
                            "Smoothie ; Avocado Toast ; Cereal Bar"
                }
                "afternoon" -> {
                    //Lunch meal suggestions will appear
                    textViewPiattoPick.text = "Lunch:" +
                            " Falafel Wrap ; Basil Pesto Salad ; Sandwich"
                }
                "late afternoon" -> {
                    //Late Afternoon Snack ideas should show
                    textViewPiattoPick.text = "Snack:" +
                            " Hummus & Flatbread ; Popcorn ; Nuts"
                }
                "evening" -> {
                    //Dinner options should show
                    textViewPiattoPick.text = "Dinner:" +
                            " Tacos ; Coconut Lentil Curry ; Lasagna"
                }
                "late evening" -> {
                    //Dessert suggestions should appear
                    textViewPiattoPick.text = "Dessert:" +
                            " Ice Cream ; Chocolate ; Fruit Bowl"
                }
                //When user input doesn't match
                else -> {
                    textViewPiattoPick.text = "Try using Morning, Mid Morning, Afternoon etc"
                }
            }
        }
        resetHomebutton.setOnClickListener {
            // Clear the Meal Sugggestion and reset to how it was before
            Toast.makeText(this@MainActivity,"Back" , Toast.LENGTH_SHORT).show()
            editTextTOD.text.clear()
            textViewPiattoPick.text = ""
        }
    }
}



           