package com.example.homeworkbuttons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var repetitionCounter : Int = 0; //repetitionTextView
    var nextButtonToPress : Int = 1;
    val buttonNumbers = (1..3).toMutableList();
    // randomize order of the buttons
    var randomizedButtonNumbers = buttonNumbers.shuffled()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create references to the fields in the activity_main layout
        val buttonOneClick   = findViewById<Button>(R.id.button_one);
        val buttonTwoClick   = findViewById<Button>(R.id.button_two);
        val buttonThreeClick = findViewById<Button>(R.id.button_three);
        val nextToClickText  = findViewById<TextView>(R.id.nextToClickText);
        val repetitionText   = findViewById<TextView>(R.id.repetitionTextView);

        nextToClickText.text = "Next Button To Click : " + nextButtonToPress.toString();
        repetitionText.text = "Number of repetitions : " + repetitionCounter.toString();

        changeButtonOrder(buttonOneClick, buttonTwoClick, buttonThreeClick);

        //setup click listeners
        buttonOneClick.setOnClickListener{
            handleButtonClicks(randomizedButtonNumbers[0], repetitionText ,nextToClickText, buttonOneClick, buttonTwoClick, buttonThreeClick);
        }

        buttonTwoClick.setOnClickListener{
            handleButtonClicks(randomizedButtonNumbers[1], repetitionText ,nextToClickText, buttonOneClick, buttonTwoClick, buttonThreeClick);
        }

        buttonThreeClick.setOnClickListener{
            handleButtonClicks(randomizedButtonNumbers[2], repetitionText ,nextToClickText, buttonOneClick, buttonTwoClick, buttonThreeClick);
        }
    }

    fun handleButtonClicks(btnNumber: Int,
                           repetitionText : TextView,
                           nextToClickText : TextView,
                           buttonOneClick : Button,
                           buttonTwoClick : Button,
                           buttonThreeClick : Button,
    ){
        if(btnNumber == nextButtonToPress){
            if (btnNumber == 1){
                nextButtonToPress = 2;
            } else if (btnNumber == 2) {
                nextButtonToPress = 3;
            } else
            if ( btnNumber == 3){
                repetitionCounter += 1;
                nextButtonToPress = 1;
                repetitionText.text = "Number of repetitions : " + repetitionCounter.toString();

                //for the next repetition randomize buttons again
                randomizedButtonNumbers = buttonNumbers.shuffled()
                changeButtonOrder(buttonOneClick, buttonTwoClick, buttonThreeClick);
            }
            nextToClickText.text = "Next Button To Click : " + nextButtonToPress.toString();
        }
    }

    fun changeButtonOrder(
        buttonOneClick : Button,
        buttonTwoClick : Button,
        buttonThreeClick : Button,
    ){
        //change button labels to suit the randomized list
        buttonOneClick.text     = "Button " + randomizedButtonNumbers[0].toString();
        buttonTwoClick.text     = "Button " + randomizedButtonNumbers[1].toString();
        buttonThreeClick.text   = "Button " + randomizedButtonNumbers[2].toString();
    }
}