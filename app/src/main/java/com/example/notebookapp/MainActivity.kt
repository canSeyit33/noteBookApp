package com.example.notebookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.notebookapp.databinding.ActivityMainBinding
import com.example.notebookapp.ui.viewModel.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            viewModel.textViewFlow.collect{
                binding.tvShow.text = it

                binding.buttonUpdate.setOnClickListener {
                    val newText = binding.inputText.text.toString()
                    viewModel.update(newText)
                }

                binding.buttonDelete.setOnClickListener {
                    viewModel.delete()
                }
            }
        }







    }

}