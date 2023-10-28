package com.example.notebookapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notebookapp.data.repo.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var repo = Repository()
    private val _textViewFlow = MutableStateFlow<String>("SCB33")
    val textViewFlow = _textViewFlow.asStateFlow()


    fun update(newText:String){
        _textViewFlow.value = newText
    }

    fun delete(){
        CoroutineScope(Dispatchers.Main).launch {
            _textViewFlow.value = repo.delete()
        }
    }




}