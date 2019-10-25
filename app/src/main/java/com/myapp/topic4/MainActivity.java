package com.myapp.topic4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    public ListView lstCountries;

    public static final String countries[] = {"Nepal", "India", "China", "UK", "US", "Canada"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstCountries = findViewById(R.id.lstCountries);

        ArrayAdapter countryAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, countries);

        lstCountries.setAdapter(countryAdapter);
    }
}
