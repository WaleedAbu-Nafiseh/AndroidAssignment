package com.example.project1.view.cars;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.project1.R;
import com.example.project1.model.Cars.CarsDAO;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class CarListActivity extends AppCompatActivity {
    private ListView list;
    private  ArrayList carsList;
    private ArrayAdapter<String> carsListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);
        //Bind the listView to the object
        list = findViewById(R.id.lstvwCarsList);


        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=prefs.edit();
        String carsJSON = gson.toJson(CarsDAO.getCarsList());
        editor.putString("carsList",carsJSON);
        editor.commit();



        //Add its in the arrayList which wil show. It is possibe to change a string to an array list.
        carsList = new ArrayList<String>();
        carsList.addAll(Arrays.asList(CarsDAO.getCarsList()));

        carsListAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, carsList);

        list.setAdapter(carsListAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(CarListActivity.this, CarDetailsActivity.class);
                   intent.putExtra("carPosition",position);
                    startActivity(intent);

            }
        };
        list.setOnItemClickListener(itemClickListener);
    }
}
