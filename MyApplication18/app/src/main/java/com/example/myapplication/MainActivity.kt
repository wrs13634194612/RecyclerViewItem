package com.example.myapplication



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.ILanguageRecycleListener
import com.example.myapplication.adapter.LanguageRecycleAdapter
import com.example.myapplication.viewmodel.LanguageViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ILanguageRecycleListener {

    val languageViewModel by viewModels<LanguageViewModel>()
    lateinit var languageRecycleAdapter: LanguageRecycleAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvLanguage.layoutManager = LinearLayoutManager(this)
        languageRecycleAdapter = LanguageRecycleAdapter(languageViewModel.languageLiveData.value!!)
        languageRecycleAdapter.listener = this
        rvLanguage.adapter = languageRecycleAdapter
        languageViewModel.languageLiveData.observe(this, Observer {
            languageRecycleAdapter.notifyDataSetChanged()
        })

    }

    fun addLanguage(view: View) {
        val language = etLanguage.text.toString()
        languageViewModel.addLanguage(language)
    }

    override fun itemOnClick(position: Int) {
        languageViewModel.removeLanguage(position)
    }
}
