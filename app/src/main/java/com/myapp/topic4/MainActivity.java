package com.myapp.topic4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public ListView lstCountries;

    public static final String countries[] = {"Nepal", "Kathmandu", "India", "New Delhi", "China", "Beijing", "US", "Washington D.C."};

    private Map<String, String> countriesMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstCountries = findViewById(R.id.lstCountries);

        countriesMap = new HashMap<>();
        for(int i=0; i<countries.length; i+=2){
            countriesMap.put(countries[i], countries[i+1]);

        }

        ArrayAdapter countryAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, new ArrayList<String>(countriesMap.keySet()));

        lstCountries.setAdapter(countryAdapter);

        lstCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country = parent.getItemAtPosition(position).toString();
                String capital = countriesMap.get(country);
                // Toast.makeText(MainActivity.this, "Capital of " + country + " is " + capital, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, CapitalActivity.class);
                intent.putExtra("capital", capital);
                startActivity(intent);
            }
        });
    }
}
