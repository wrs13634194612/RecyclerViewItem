package com.example.myapplication.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Maulana Ibrahim on 15/August/2020
 * Email maulibrahim19@gmail.com
 */
class LanguageViewModel : ViewModel() {
    val languageList = mutableListOf<String>("Java", "Python", "C", "Swift")
    val languageLiveData: MutableLiveData<MutableList<String>> = MutableLiveData(languageList)

    fun addLanguage(lang: String) {
        languageList.add(lang)
        languageLiveData.value = languageList
    }

    fun removeLanguage(position: Int) {
        languageList.removeAt(position)
        languageLiveData.value = languageList
    }
}