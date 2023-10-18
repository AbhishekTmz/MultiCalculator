package com.example.multicalculator.android

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.multicalculator.Greeting
import androidx.compose.runtime.MutableState
import androidx.compose.material.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CalcView()
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
      CalcView()
    }
}
@Composable
fun CalcView(){
var displayText = remember {mutableStateOf("0")}
    val  leftNumber by rememberSaveable { mutableStateOf(0)}
    val  rightNumber by rememberSaveable { mutableStateOf(0)}
    var operation by rememberSaveable { mutableStateOf("") }
    var complete by rememberSaveable { mutableStateOf(false) }
if (complete && operation.isNotEmpty()){
    var answer  = 0;
    when (operation){
        "+"-> answer = leftNumber + rightNumber
        "-"-> answer =leftNumber - rightNumber
        "*"-> answer = leftNumber * rightNumber
        "/"-> answer = leftNumber / rightNumber
    }
    displayText.value = answer.toString()
}else if (operation.isNotEmpty() && !complete){
    displayText.value = rightNumber.toString()
}else{
    displayText.value = leftNumber.toString()
}
    fun numPress(){}
    fun operationPress(){}
    fun equalsPress(){}

    Column(modifier = Modifier.background(Color.LightGray) then  Modifier.padding(0.dp)) {
Row {
    CalcDisplay(displayText)
}
        Row {
            Column {
for (i in 7 downTo 1 step 3) CalcRow(display = displayText, startNum = i, numButtons = 3)
                Row {
                    CalcNumericButton(number = 0, display =displayText )
                    CalcEqualsButton(display = displayText)
                }
            }
            Column {
                CalcOperationButton(operation = "+", display = displayText  )
                CalcOperationButton(operation = "-", display = displayText  )
                CalcOperationButton(operation = "*", display = displayText  )
                CalcOperationButton(operation = "/", display = displayText  )
            }
        }
    }
}
@Composable
fun CalcRow(display: MutableState<String>, startNum : Int, numButtons : Int){
val endNum = startNum + numButtons
    Row (modifier = Modifier.padding(0.dp)){
for (i in startNum until endNum){
    CalcNumericButton(number = i, display = display)
}
    }
}
@Composable
fun CalcDisplay(display: MutableState<String>){
Text(text = display.value, modifier = Modifier
    .height(400.dp)
    .fillMaxWidth()
    .padding(9.dp) , fontSize = 100.sp)
}
@Composable
fun CalcNumericButton(number : Int , display: MutableState<String>){
Button(onClick = {
                 display.value += number.toString()
}, modifier = Modifier
    .padding(4.dp)
    .size(95.dp) , colors = ButtonDefaults.buttonColors(backgroundColor = Color.Unspecified), shape = RoundedCornerShape(10.dp) )
{
Text(text = number.toString() , fontSize = 30.sp , fontWeight = FontWeight.Bold)
}
}
@Composable
fun CalcOperationButton(operation : String , display: MutableState<String>){
Button(onClick = { /*TODO*/ },
    modifier = Modifier
        .padding(4.dp)
        .size(95.dp),colors = ButtonDefaults.buttonColors(backgroundColor = Color.Unspecified), shape = RoundedCornerShape(10.dp)
) {
    Text(text = operation , fontSize = 30.sp , fontWeight = FontWeight.Bold)
}
}
@Composable
fun CalcEqualsButton(display : MutableState<String>){
Button(modifier = Modifier
    .padding(4.dp)
    .size(95.dp),onClick = {display.value = "0"} , colors = ButtonDefaults.buttonColors(backgroundColor = Color.Unspecified) ) {
Text(text = "=" ,  fontSize = 30.sp , fontWeight = FontWeight.Bold)
}


}
