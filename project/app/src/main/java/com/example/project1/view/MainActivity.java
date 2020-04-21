package com.example.project1.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.project1.R;
import com.example.project1.model.Cars.CarsDAO;
import com.example.project1.model.abstractData.AbstractItem;
import com.example.project1.view.Electronics.ElectronicsListActivity;
import com.example.project1.view.Food.FoodListActivity;
import com.example.project1.view.cars.CarListActivity;
import com.example.project1.view.cloths.ClothesDetailsActivity;
import com.example.project1.view.cloths.ClothesListActivity;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static final String CARS= "cars";
    static final String FOOD= "Food";
    static final String ELECTRONICS= "Electronics";
    static final String CLOTHES= "Clothes";
    private ListView list;
    private  ArrayList storesList;
    private ArrayAdapter<String> storesListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.lstVwStoresList);
        storesList = new ArrayList<String>();

        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(prefs.contains("selectedItemsFile")){
            Log.e("e","exists");
        }else{ SharedPreferences.Editor editor=prefs.edit();

            ArrayList<AbstractItem> selectedItems= new ArrayList<AbstractItem>();
            String selectedItemsJSON = gson.toJson(selectedItems);
            editor.putString("selectedItemsFile",selectedItemsJSON);
            editor.commit();}



        //Creation of dummy data
        storesList.add(CARS);
        storesList.add(FOOD);
        storesList.add(ELECTRONICS);
        storesList.add(CLOTHES);
        storesListAdapter = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_spinner_item, storesList);
        list.setAdapter(storesListAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent = new Intent(MainActivity.this, CarListActivity.class);
                    startActivity(intent);
                }else if (position==1){
                    Intent intent = new Intent(MainActivity.this, FoodListActivity.class);
                    startActivity(intent);
                }else if (position==2){
                    Intent intent = new Intent(MainActivity.this, ElectronicsListActivity.class);
                    startActivity(intent);
                }else if (position==3){
                    Intent intent = new Intent(MainActivity.this, ClothesListActivity.class);
                    startActivity(intent);
                }
            }
        };
        list.setOnItemClickListener(itemClickListener);

    }

    public void goToSelectedItems(View view) {
        Intent intent = new Intent(MainActivity.this, SelectedItemsActivity.class);
        startActivity(intent);
    }
}