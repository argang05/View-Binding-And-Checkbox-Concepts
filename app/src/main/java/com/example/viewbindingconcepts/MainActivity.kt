 package com.example.viewbindingconcepts
/*
View binding is a feature that makes it easier to write code that interacts with views. Once view binding is
enabled in a module, it generates a binding class for each XML layout file present in that module. An
instance of a binding class contains direct references to all views that have an ID in the corresponding layout.
 */
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.viewbindingconcepts.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {
     //Declaring view-binding variable:
    lateinit var binding : ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Initializing view-binding variable:
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        //Eg of ViewBinding:
        //binding.myTextView.text = "Hello ABG";

        binding.submitButton.setOnClickListener {
            if(binding.checkBox.isChecked){
                //If checkbox is check then print a confirmation toast message...
                Toast.makeText(
                    this,
                    "Thank You For Submitting the Form!",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                //Otherwise display a warning toast message and make the check box red:
                binding.checkBox.buttonTintList = ColorStateList.valueOf(Color.RED);
                binding.checkBox.setTextColor(Color.RED);
                Toast.makeText(
                    this,
                    "Please accept the terms and conditions!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
}