package com.example.myapplication19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements ILanguageRecycleListener {
    private LanguageRecycleAdapter languageRecycleAdapter;
    private RecyclerView rvLanguage;
    private List<String> languageList = new ArrayList<>();
    private EditText editText;
    private Button btn_main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        languageList.add("java");
        languageList.add("kotlin");
        languageList.add("ruby");
        languageList.add("flutter");

        rvLanguage = findViewById(R.id.rvLanguage);
        editText= findViewById(R.id.etLanguage);
        btn_main= findViewById(R.id.btn_main);

        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(this);
        rvLanguage.setLayoutManager(layoutManager);
        languageRecycleAdapter = new LanguageRecycleAdapter(languageList, this);
        rvLanguage.setAdapter(languageRecycleAdapter);

        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String etString = editText.getText().toString();
                languageList.add(etString);
                languageRecycleAdapter.setData(languageList);
                languageRecycleAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void itemOnClick(int title, int position) {
        Log.e("TAG", "itemOnClick" + title + ", " + position);
        if (title==103){
            languageList.remove(position);
            languageRecycleAdapter.setData(languageList);
            languageRecycleAdapter.notifyDataSetChanged();
        }
    }
}