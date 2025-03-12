package com.example.homework2

import androidx.lifecycle.ViewModel

class AppInfoVM (private var repository: BookRepository): ViewModel() {

    fun getName(): String{
        return repository.getAppName()
    }
    fun getDevName() :String{
        return repository.getAppDeveloperName()
    }
    fun getVersion(): String{
        return repository.getAppVersion()
    }

}