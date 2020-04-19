package com.example.project1.view.cloths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.project1.R;
import com.example.project1.model.Cars.CarsDAO;
import com.example.project1.model.abstractData.AbstractItem;
import com.example.project1.model.cloths.ClothesDAO;
import com.example.project1.view.Electronics.ElectronicsDetailsActivity;
import com.example.project1.view.Electronics.ElectronicsListActivity;
import com.example.project1.view.MainActivity;
import com.example.project1.view.cars.CarDetailsActivity;
import com.example.project1.view.cars.CarListActivity;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ClothesListActivity extends AppCompatActivity {
    private ArrayList ClothesList ;
    private ListView clothesListView;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_list);
        clothesListView = findViewById(R.id.clothes_list);
        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        String carsJSON = gson.toJson(CarsDAO.getCarsList());
        editor.putString("ClothesList", carsJSON);
        editor.commit();
        ClothesList= new ArrayList<String>();
        ClothesList.addAll(ClothesDAO.getClothesList());

        ArrayAdapter<AbstractItem> ClothesListAdapter = new ArrayAdapter<AbstractItem>(this,
                android.R.layout.simple_list_item_1, ClothesList);
        clothesListView.setAdapter(ClothesListAdapter);
        clothesListView.setBackgroundColor(Color.WHITE);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ClothesListActivity.this, ClothesDetailsActivity.class);
                intent.putExtra("Cloth_id", (int) id);
                startActivity(intent);

            }

        };

        clothesListView.setOnItemClickListener(itemClickListener);
        }
    public void gotoHome(View view) {
        Intent intent = new Intent(ClothesListActivity.this, MainActivity.class);
        startActivity(intent);

    }



    }




