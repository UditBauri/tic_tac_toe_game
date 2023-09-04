package com.example.tic_tac_toe

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.tic_tac_toe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    var flag = 0
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    // Creating a click function for the Buttons
    fun click(view:View) {
        val currentImg = view as Button

        if (currentImg.text == "") {

            count++

            if (flag == 0) {
                currentImg.text = "X"
                flag = 1
            } else {
                currentImg.text = "O"
                flag = 0
            }

            val b1 = binding.bt1.text.toString()
            val b2 = binding.bt2.text.toString()
            val b3 = binding.bt3.text.toString()
            val b4 = binding.bt4.text.toString()
            val b5 = binding.bt5.text.toString()
            val b6 = binding.bt6.text.toString()
            val b7 = binding.bt7.text.toString()
            val b8 = binding.bt8.text.toString()
            val b9 = binding.bt9.text.toString()

            // winner logic for tic_tac_toe game!................................

            // for Horizontal winner logic!......................................
            if (b1 == b2 && b2 == b3 && b3 != "") {
                Toast.makeText(this@MainActivity, "Winner $b1", Toast.LENGTH_SHORT).show()
                result("Play again")
            } else if (b4 == b5 && b5 == b6 && b6 != "") {
                Toast.makeText(this@MainActivity, "Winner $b4", Toast.LENGTH_SHORT).show()
                result("Play again")
            } else if (b7 == b8 && b8 == b9 && b9 != "") {
                Toast.makeText(this@MainActivity, "Winner $b7", Toast.LENGTH_SHORT).show()
                result("Play again")
            }


            // for vertical winner logic!.................................
            else if (b1 == b4 && b4 == b7 && b7 != "") {
                Toast.makeText(this@MainActivity, "Winner $b1", Toast.LENGTH_SHORT).show()
                result("Play again")
            } else if (b2 == b5 && b5 == b8 && b8 != "") {
                Toast.makeText(this@MainActivity, "Winner $b2", Toast.LENGTH_SHORT).show()
                result("Play again")
            } else if (b3 == b6 && b6 == b9 && b9 != "") {
                Toast.makeText(this@MainActivity, "Winner $b3", Toast.LENGTH_SHORT).show()
                result("Play again")
            }


            // for diagonal logic!.............................................
            else if (b1 == b5 && b5 == b9 && b9 != "") {
                Toast.makeText(this@MainActivity, "Winner $b1", Toast.LENGTH_SHORT).show()
                result("Play again")
            }
            else if (b3 == b5 && b5 == b7 && b7 != "") {
                Toast.makeText(this@MainActivity, "Winner $b3", Toast.LENGTH_SHORT).show()
                result("Play again")
            }

            // for Match Draw!..................................................
            else if(count==9){
                Toast.makeText(this@MainActivity,"Match Draw",Toast.LENGTH_SHORT).show()
                result("Play again")
            }
        }
    }

    // Adding alert dialog box!..................................................
    fun result(title:String){
        try {
            AlertDialog.Builder(this)
                .setTitle(title)
                .setPositiveButton("Reset")
                { _, _ ->
                    newGame()
                }
                .setCancelable(false)
                .show()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    // Creating a function to Reset the Game!.....................................
    fun newGame(){

        binding.bt1.text = ""
        binding.bt2.text = ""
        binding.bt3.text = ""
        binding.bt4.text = ""
        binding.bt5.text = ""
        binding.bt6.text = ""
        binding.bt7.text = ""
        binding.bt8.text = ""
        binding.bt9.text = ""

        flag=0
        count =0
    }

    // Creating a Alert Dialog for exit the game!...................................
    fun exitGame(exitTitle: String){
        try {
            AlertDialog.Builder(this)
                .setTitle(exitTitle)
                .setPositiveButton("No")
                { _, _ ->
                    newGame()//this method will reset the game......................
                }
                .setNegativeButton("Exit")
                { _, _ ->

                    //this method will destroy or exit the game..........
                    finishAndRemoveTask()
                    System.exit(0)
                }
                .setCancelable(true)
                .show()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    // Create onBackPressed function to choose to exit or reset the game!..............
    @Suppress("OVERRIDE_DEPRECATION")
    override fun onBackPressed() {
        exitGame("Exit Game")
    }
}