package com.elsharif.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.elsharif.viewmodel.ui.theme.ViewModelTheme
import com.elsharif.viewmodel.viewmodel.ContactsViewModel

class MainActivity : ComponentActivity() {


//    private val viewModel by viewModels<ContactsViewModel>()
//    private val viewModel =ContactsViewModel()

    /*
    private val viewModel by viewModels<ViewModel> (  )

    private val viewModelFactory by viewModels<ViewModel> (
        factoryProducer = {
            object :ViewModelProvider.Factory{
                override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
                    return super.create(modelClass)
                // return ViewModel(pass the argument ) as T
                    // this if we need to pass data to viewModel
                }
            }
        }
    )
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewModelTheme {
              // we use this method if we will don't pass parameter to the constructor of viewModel
                val viewModel= viewModel<ContactsViewModel>()


                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = viewModel.backgroundColor
                )
                {

                    Button(onClick = { viewModel.changeBackgroundColor() }) {
                        Text(text = "Change Background")
                    }
                    
                 /*   val text = viewModel.text.collectAsState()

                    Column(
                        modifier=Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Spacer(modifier = Modifier.height(35.dp))
                        Text(text = text.value)


                        Spacer(modifier = Modifier.height(35.dp))

                        TextField(value =text.value, onValueChange ={viewModel.changeText(it)} )
                    }
                   */


                }
            }
        }
    }
}

