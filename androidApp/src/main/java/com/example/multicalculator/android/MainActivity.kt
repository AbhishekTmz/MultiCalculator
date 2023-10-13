package com.example.multicalculator.android

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.multicalculator.Greeting
import androidx.compose.runtime.MutableState
import androidx.compose.material.Button
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingView(Greeting().greet())
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }

}
@Composable
fun CalcView(){

}
@Composable
fun CalcRow(){

}
@Composable
fun CalcDisplay(display: MutableState<String>){
Text(text = display.value, modifier = Modifier.height(50.dp).fillMaxWidth().padding(5.dp))
}
@Composable
fun CalcNumericButton(number : Int , display: MutableState<String>){
Button(onClick = {
                 display.value += number.toString()
}, modifier = Modifier.padding(4.dp))

{
Text(text = number.toString())
}
}
@Composable
fun CalcOperationButton(operation : String , display: MutableState<String>){
Button(onClick = { /*TODO*/ },
    modifier = Modifier.padding(4.dp)
) {
    Text(text = operation)
}
}
@Composable
fun CalcEqualsButton(display : MutableState<String>){
Button(onClick = {
    display.value = "0"
},
modifier = Modifier.padding(4.dp)    )
{ }
}
