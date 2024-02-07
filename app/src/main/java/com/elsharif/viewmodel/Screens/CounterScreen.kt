package com.elsharif.viewmodel.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.elsharif.viewmodel.viewmodel.CounterViewModel


@Composable
fun CounterContent(
    counter:String,
    onClickMinus:()->Unit,
    onClickPlus:()->Unit

) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier=Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Text(text = counter, fontSize = 96.sp)

            Row {
                Button(onClick = onClickMinus) {

                    Text(text = "-", fontSize = 48.sp)

                }


                Button(onClick = onClickPlus) {

                    Text(text = "+", fontSize = 48.sp)

                }

            }


        }
    }
}


// State Hoisting in Jetpack Compose

@Composable
fun CounterScreen(
    viewModel: CounterViewModel = hiltViewModel() ,//this hiltViewModel is responsible for search for  "CounterViewModel" if not found it create it and pass it as a default value


    ) {


    val state by viewModel.state.collectAsState()
    CounterContent(counter = state.toString(),
        onClickMinus = viewModel::onDecreaseCounter,
        onClickPlus=viewModel::onIncreaseCounter)


}