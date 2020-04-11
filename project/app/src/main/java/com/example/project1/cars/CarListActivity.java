package com.example.project1.cars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.project1.R;
import com.example.project1.model.Cars.CarItem;
import com.example.project1.model.Cars.CarsDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

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
        //Add its in the arrayList which wil show. It is possibe to change a string to an array list.
        carsList = new ArrayList<String>();
        carsList.addAll(Arrays.asList(CarsDAO.getCarsList()));

        carsListAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, carsList);

        list.setAdapter(carsListAdapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view,
                                       int position,
                                       long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
    }
}
