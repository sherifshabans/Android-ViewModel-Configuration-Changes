package com.elsharif.viewmodel.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class CounterViewModel :ViewModel() {


    /*
    viewModel acts as the bridge between your UI and data layer . 
    it receives user actions from UI,
    provides LiveData from repository to be observed by UI ,
    and it stores and processes your screen states so that they don't get lost during
    configuration changes (like screen rotations).
    so you can think like viewModel is the brain of your app
     */

    private val _state = MutableStateFlow(0)
    val state = _state.asStateFlow()

    fun onIncreaseCounter(){
        _state.update {
            it+1
        }
    }
    fun onDecreaseCounter(){
        _state.update {
            it-1
        }
    }
}