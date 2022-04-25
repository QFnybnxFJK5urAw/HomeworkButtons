`res/layout/activity_main.xml`

Here is the view placed. Dragged and dropped 3x Buttons and 2x TextViews and assigned them IDs with giving them constraints where they will be placed on the screen. You can also edit it via the source XML file.

`app/java/com.example.homeworkbuttons/MainActivity.kt`

Here is the main logic.

Variables : 
- repetitionCounter - tracks the number of successful repetitions.
- nextButtonToPress - keeps track of what is the next button that needs to be pressed
- buttonNumbers - a list containing [1,2,3] elements
- randomizedButtonNumbers - list with randomly ordered buttonNumbers list elements

This code is used to run start the Main Activity of the app:

`super.onCreate(savedInstanceState)`

`setContentView(R.layout.activity_main)`

----

With `findViewById` we create reference to the Layout View Objects.

`setOnClickListener` - we create an action what will happen when the user clicks on the buttons

### The way buttons are randomly orderered

randomizedButtonNumbers will contain the random list where we will assing the
- randomizedButtonNumbers[0] - to the first button on the screen
- randomizedButtonNumbers[1] - to the second button on the screen
- randomizedButtonNumbers[2] - to the third button on the screen

We are not moving buttons on the screen just changing their label and keeping track of the button number by looking at the element at certain index.
