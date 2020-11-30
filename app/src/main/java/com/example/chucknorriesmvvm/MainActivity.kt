package com.example.chucknorriesmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorriesmvvm.Model.NorrisRepository
import com.example.chucknorriesmvvm.ViewModel.NorriesViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: NorriesViewModel by lazy{
        ViewModelProvider(this,
        object:ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return NorriesViewModel(repository) as T
            }
        }).get(NorriesViewModel::class.java)
    }

    private val repository: NorrisRepository by lazy {
        NorrisRepository()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //connect your view with observable
        viewModel.getJokeLiveData().observe(this,
                object : Observer<String> {
                //Similarly to onNext from RxJava
                //Get data when Observable change
                    override fun onChanged(t: String?) {
                        //todo populate into MainThread View

                    }

                })
    viewModel.getJokeLiveData()
    }
}